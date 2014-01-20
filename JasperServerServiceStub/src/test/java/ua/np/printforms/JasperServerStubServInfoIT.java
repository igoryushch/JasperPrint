package ua.np.printforms;

/**
 * Copyright 2013 Nova Poshta property
 * <p/>
 * for internal use only!
 * <p/>
 * User: yushchenko.i
 * email: yushchenko.i@novaposhta.ua
 * Date: 19.11.13
 * Time: 10:26
 */

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.np.services.printforms.ServerInfo;
import ua.np.services.printforms.ServerInfoService;

import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.net.URL;

@ContextConfiguration(locations = "classpath*:/application-context-si.xml")
public class JasperServerStubServInfoIT extends AbstractTestNGSpringContextTests {

    @javax.annotation.Resource
    private ServerInfoService clientServerInfoService;
    private final static String ENDPOINT_ADDRESS = "http://localhost:8070/";

    @Test
    public void testServerInfoInjected () throws Exception {

        Assert.assertEquals ( clientServerInfoService.getServerVersion (), "5.5.0" );
        Assert.assertEquals ( clientServerInfoService.getServerEdition (), "PRO" );
        Assert.assertEquals ( clientServerInfoService.getFeatures (), "Fusion AHD EXP DB ANA AUD MT " );
        Assert.assertEquals ( clientServerInfoService.getServerEditionName (), "Enterprise" );
        Assert.assertEquals ( clientServerInfoService.getServerLicenseType (), "Evaluation" );
        Assert.assertEquals ( clientServerInfoService.getServerBuild (), "20131024_0554" );

        Response response = clientServerInfoService.getServerInfo ();

        Assert.assertEquals ( response.getStatus (), 200 );
        Assert.assertTrue ( response.hasEntity () );
        Assert.assertNotNull ( response.getEntity () );

    }

    @Test
    public void testServerInfoElementsWebClient () throws Exception {

        WebClient client = WebClient.create ( ENDPOINT_ADDRESS );
        String parameter = client.path ( "jasperserver/rest_v2/serverInfo/version" ).accept ( "text/plain" ).get ( String.class );

        Assert.assertEquals ( parameter, "5.5.0" );

        client = WebClient.create ( ENDPOINT_ADDRESS );
        parameter = client.path ( "jasperserver/rest_v2/serverInfo/features" ).accept ( "text/plain" ).get ( String.class );

        Assert.assertEquals ( parameter, "Fusion AHD EXP DB ANA AUD MT " );

        client = WebClient.create ( ENDPOINT_ADDRESS );
        parameter = client.path ( "jasperserver/rest_v2/serverInfo/edition" ).accept ( "text/plain" ).get ( String.class );

        Assert.assertEquals ( parameter, "PRO" );

        client = WebClient.create ( ENDPOINT_ADDRESS );
        parameter = client.path ( "jasperserver/rest_v2/serverInfo/editionName" ).accept ( "text/plain" ).get ( String.class );

        Assert.assertEquals ( parameter, "Enterprise" );

        client = WebClient.create ( ENDPOINT_ADDRESS );
        parameter = client.path ( "jasperserver/rest_v2/serverInfo/licenseType" ).accept ( "text/plain" ).get ( String.class );

        Assert.assertEquals ( parameter, "Evaluation" );

        client = WebClient.create ( ENDPOINT_ADDRESS );
        parameter = client.path ( "jasperserver/rest_v2/serverInfo/build" ).accept ( "text/plain" ).get ( String.class );

        Assert.assertEquals ( parameter, "20131024_0554" );

        client = WebClient.create ( ENDPOINT_ADDRESS );
        client.accept ( "text/xml" );
        ServerInfo info = client.path ( "jasperserver/rest_v2/serverInfo" ).accept ( "application/xml" ).get ( ServerInfo.class );

        Assert.assertNotNull ( info );

        Assert.assertEquals ( info.getVersion (), "5.5.0" );

    }

    @Test
    public void testServerInfoElementsURLStream () throws Exception {

        URL url = new URL ( ENDPOINT_ADDRESS + "jasperserver/rest_v2/serverInfo/version" );
        InputStream in = url.openStream ();
        Assert.assertEquals ( getStringFromInputStream ( in ), "5.5.0" );

        url = new URL ( ENDPOINT_ADDRESS + "jasperserver/rest_v2/serverInfo/features" );
        in = url.openStream ();
        Assert.assertEquals ( getStringFromInputStream ( in ), "Fusion AHD EXP DB ANA AUD MT " );

        url = new URL ( ENDPOINT_ADDRESS + "jasperserver/rest_v2/serverInfo/edition" );
        in = url.openStream ();
        Assert.assertEquals ( getStringFromInputStream ( in ), "PRO" );

        url = new URL ( ENDPOINT_ADDRESS + "jasperserver/rest_v2/serverInfo/editionName" );
        in = url.openStream ();
        Assert.assertEquals ( getStringFromInputStream ( in ), "Enterprise" );

        url = new URL ( ENDPOINT_ADDRESS + "jasperserver/rest_v2/serverInfo/licenseType" );
        in = url.openStream ();
        Assert.assertEquals ( getStringFromInputStream ( in ), "Evaluation" );

        url = new URL ( ENDPOINT_ADDRESS + "jasperserver/rest_v2/serverInfo/build" );
        in = url.openStream ();
        Assert.assertEquals ( getStringFromInputStream ( in ), "20131024_0554" );

        url = new URL ( "http://localhost:8070/jasperserver/rest_v2/serverInfo" );
        in = url.openStream ();
        String xmlString = getStringFromInputStream ( in );

        Assert.assertEquals ( xmlString.substring ( 74, 87 ), "20131024_0554" );
        Assert.assertEquals ( xmlString.substring ( 56, 66 ), "serverInfo" );

    }

    private static String getStringFromInputStream ( InputStream in ) throws Exception {
        CachedOutputStream bos = new CachedOutputStream ();
        IOUtils.copy ( in, bos );
        in.close ();
        bos.close ();
        return bos.getOut ().toString ();
    }

}
