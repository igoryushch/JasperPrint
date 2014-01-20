package ua.np.printforms;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.np.services.printforms.ReportExecutionsService;

import java.io.IOException;

/**
 * Copyright (C) 2013 Nova Poshta. All rights reserved.
 * http://novaposhta.ua/
 * <p/>
 * for internal use only!
 * <p/>
 * User: yushchenko.i
 * email: yushchenko.i@novaposhta.ua
 * Date: 30.12.13
 */

@ContextConfiguration(locations = "classpath*:/application-context-re.xml")
public class JasperServerStubExecutionIT extends AbstractTestNGSpringContextTests {

    @Autowired
    @Qualifier(value = "reportExecutionsService")
    private ReportExecutionsService reportExecutionService;

    @javax.annotation.Resource
    private ReportExecutionsService clientReportExecutionService;

    @Test
    public void testConfiguration() {
        Assert.assertNotNull( reportExecutionService );
        Assert.assertNotNull(clientReportExecutionService);
        Assert.assertNotNull(applicationContext.getBean("endpointReportExecution"));
    }

    @Test
    public void testReportExecution(){

        String endpointUrl = "http://localhost:8070/jasperserver/rest_v2/reportExecutions";
        HttpClient httpclient = HttpClientBuilder.create().build();

        String request = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<reportExecutionRequest>\n" +
                "    <reportUnitUri>/root/Reports/Test</reportUnitUri>\n" +
                "    <async>false</async>\n" +
                "    <freshData>true</freshData>\n" +
                "    <ignorePagination>true</ignorePagination>\n" +
                "    <interactive>false</interactive>\n" +
                "    <outputFormat>pdf</outputFormat>\n" +
                "    <parameters>\n" +
                "        <reportParameter name=\"Number\">\n" +
                "            <value>10015283291</value>\n" +
                "        </reportParameter>\n" +
                "    </parameters>\n" +
                "    <saveDataSnapshot>false</saveDataSnapshot>\n" +
                "</reportExecutionRequest>\n";

        HttpPost postRequest = new HttpPost( endpointUrl );

        try {
            StringEntity entity = new StringEntity( request, "UTF-8" );
            postRequest.addHeader("Content-Type","application/xml; charset=UTF-8");
            postRequest.setEntity( entity );
            HttpResponse response = httpclient.execute( postRequest );

            Assert.assertEquals( response.getStatusLine().getStatusCode(), HttpStatus.SC_OK, "POST request result code was " + response.getStatusLine().getStatusCode());

            HttpGet getRequest = new HttpGet( endpointUrl + "/677629003_1355225037212_1/exports/pdf/outputResource" );
            HttpResponse finalResponse = httpclient.execute( getRequest );
            Assert.assertEquals( finalResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK );

        } catch( IOException e ) {
            e.printStackTrace();
        }
    }

}
