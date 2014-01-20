package ua.np.services.printforms;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Copyright 2013 Nova Poshta property
 * <p/>
 * for internal use only!
 * <p/>
 * User: yushchenko.i
 * email: yushchenko.i@novaposhta.ua
 * Date: 25.11.13
 * Time: 9:41
 */

@ContextConfiguration(locations = "classpath*:/ua.np.services.printforms/JasperPrintServiceIT-context.xml")
public class JasperServerClientIntegrationTest  extends AbstractTestNGSpringContextTests {

    @Value( "${reportPath}" )
    private String reportPath;
    @Value( "${savedReportResultFile}" )
    private String savedReportResultFile;
    @Value( "${fileFormat}" )
    private String fileFormat;
    @Value( "${jasperServerStubAddress}" )
    private String jasperServerAddress;

    @Test
    public void testDependenciesInjection(){
        Assert.assertNotNull( reportPath, "Property {reportPath} has not been injected" );
        Assert.assertNotNull( savedReportResultFile, "Property {savedReportResultFile} has not been injected" );
        Assert.assertNotNull( fileFormat, "Property {fileFormat} has not been injected" );
        Assert.assertNotNull( jasperServerAddress, "Property {jasperServerAddress} has not been injected" );
    }

    @Test
    public void testJasperServerRestClient() {

        JasperServerRestClient restClient = new JasperServerRestClient( jasperServerAddress, "jasperadmin", "jasperadmin" );

        File resultFile = restClient.runReportInFile( getReport(), savedReportResultFile );
        Assert.assertNotNull( resultFile );
        Assert.assertTrue( resultFile.isFile() );
        Assert.assertTrue( resultFile.exists() );

        HttpResponse reportResponse = restClient.runReport( getReport() );

        Assert.assertNotNull( reportResponse );
        Assert.assertEquals( reportResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK );


    }

    private Report getReport() {
        Report report = new Report();
        report.setReportPath( reportPath );
        report.setOutputFormat( fileFormat );
        report.addParameter( "Number", "10015283291" );
        return report;
    }

    /*
     *   This method is for testing real JasperReports Server (not a stub)
     *
     */
    @Test(enabled=false)
    public void testReportRunningWithParametrsFromXml() throws Exception{

        Map<String, String> reportParams = getReportParametrs();

        Assert.assertNotNull( reportParams );

        Report report = new Report();
        report.setReportPath( "/PrintForms/ttn2" );
        report.setOutputFormat( fileFormat );

        for( Map.Entry<String, String> entry : reportParams.entrySet() ) {
            report.addParameter( entry.getKey(), entry.getValue() );
        }

        JasperServerRestClient restClient = new JasperServerRestClient( "http://localhost:8082/jasperserver/rest_v2/reportExecutions", "jasperadmin", "jasperadmin" );

        File resultFile = restClient.runReportInFile( report, "..\\JasperServerClient\\src\\test\\resources\\TTN" );
        Assert.assertNotNull( resultFile );
        Assert.assertTrue( resultFile.isFile() );
        Assert.assertTrue( resultFile.exists() );

    }

    private Map<String, String> getReportParametrs() throws ParserConfigurationException, SAXException, IOException {

        final String xml_params_file_path = "10015283291.xml";

        SAXParserFactory parserFactor = SAXParserFactory.newInstance();
        SAXParser parser = parserFactor.newSAXParser();
        SAXReportDataHandler handler = new SAXReportDataHandler();

        parser.parse(ClassLoader.getSystemResourceAsStream(xml_params_file_path), handler);

        return handler.getReportParams();
    }

    @AfterClass
    public void cleanUp(){
        File generated = new File( savedReportResultFile + "." + fileFormat );
        if( generated.exists() ) generated.delete();
    }

}
