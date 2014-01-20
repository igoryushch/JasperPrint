package ua.np.printforms;

/**
 * Copyright 2013 Nova Poshta property
 * <p/>
 * for internal use only!
 * <p/>
 * User: yushchenko.i
 * email: yushchenko.i@novaposhta.ua
 * Date: 19.11.13
 * Time: 10:12
 */

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.np.services.printforms.ServerInfoService;
import ua.np.services.printforms.ServerInfoServiceImpl;

import javax.ws.rs.core.Response;


public class JasperServerUnitTest {

    @Test
    public void testServerInfoElements () throws Exception {
        ServerInfoService infoService = new ServerInfoServiceImpl();
        Assert.assertEquals ( infoService.getServerVersion (), "5.5.0" );
        Assert.assertEquals ( infoService.getFeatures (), "Fusion AHD EXP DB ANA AUD MT " );
        Assert.assertEquals ( infoService.getServerEdition (), "PRO" );
        Assert.assertEquals ( infoService.getServerEditionName (), "Enterprise" );
        Assert.assertEquals ( infoService.getServerLicenseType (), "Evaluation" );
        Assert.assertEquals ( infoService.getServerBuild (), "20131024_0554" );
    }

    @Test
    public void testServerInfo () throws Exception {
        ServerInfoService infoService = new ServerInfoServiceImpl ();

        Response response = infoService.getServerInfo ();

        Assert.assertEquals ( response.getStatus (), 200 );
        Assert.assertTrue ( response.hasEntity () );
        Assert.assertNotNull ( response.getEntity () );
    }

}
