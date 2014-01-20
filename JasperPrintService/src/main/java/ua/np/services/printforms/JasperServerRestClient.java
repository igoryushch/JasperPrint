package ua.np.services.printforms;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHttpResponse;

import javax.xml.bind.*;
import java.io.*;
import java.util.Map;

/**
 * Copyright 2013 Nova Poshta property
 * <p/>
 * for internal use only!
 * <p/>
 * User: yushchenko.i
 * email: yushchenko.i@novaposhta.ua
 * Date: 25.11.13
 * Time: 16:46
 * <p/>
 * Default test values:
 * <p/>
 * endpointUrl : "http://localhost:8082/jasperserver-pro/rest_v2/reportExecutions"
 * login : "jasperadmin"
 * password : "jasperadmin"
 * REPORT_PATH = "/public/Samples/DemoTest_plain"
 */


public class JasperServerRestClient {

    private String endpointUrl;
    private HttpClient httpclient;
    private HttpClientContext context;

    public JasperServerRestClient() {
    }

    public JasperServerRestClient( String endpointUrl, String login, String password ) {

        this.endpointUrl = endpointUrl;

        httpclient = HttpClientBuilder.create().build();
        Credentials credentials = new UsernamePasswordCredentials( login, password );
        context = HttpClientContext.create();
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials( AuthScope.ANY, credentials );
        context.setCredentialsProvider( credentialsProvider );

    }

    public HttpResponse runReport(Report report){
        String request = buildReportRequest( report );
        HttpPost postRequest = new HttpPost( endpointUrl );

        try {
            StringEntity entity = new StringEntity( request, "UTF-8" );
            postRequest.addHeader("Content-Type","application/xml; charset=UTF-8");
            postRequest.setEntity( entity );
            HttpResponse response = httpclient.execute( postRequest, context );

            if( response.getStatusLine().getStatusCode() == HttpStatus.SC_OK ) {

                ReportExecution resultStatus = getReportStatus( response );

                if( "ready".equals( resultStatus.getStatus() ) ) {
                    HttpGet getRequest = new HttpGet( endpointUrl + "/" + resultStatus.getRequestId() + "/exports/" + report.getOutputFormat() + "/outputResource" );
                    HttpResponse finalResponse = httpclient.execute( getRequest, context );
                    return finalResponse;
                }
                return response;
            } else {
                return response;
            }
        } catch( IOException e ) {
            e.printStackTrace();
        }
        return new BasicHttpResponse( HttpVersion.HTTP_1_1, 400, "Not Found" );
    }

    public File runReportInFile( Report report, String path ) {
        return saveResponseToFile( runReport( report ), path, report.getOutputFormat() );
    }


    private String buildReportRequest( Report report ) {

        ObjectFactory factory = new ObjectFactory();
        ReportExecutionRequest request = factory.createReportExecutionRequest();

        request.setReportUnitUri( report.getReportPath() );
        request.setAsync( false );
        request.setFreshData( true );
        request.setIgnorePagination( true );
        request.setInteractive( false );
        request.setOutputFormat( report.getOutputFormat() );
        request.setSaveDataSnapshot( false );

        if( report.getParams().size() > 0 ) {
            ReportParameter parameter = null;
            ReportParameters parameters = factory.createReportParameters();
            for( Map.Entry<String, String> entry : report.getParams().entrySet() ) {
                parameter = factory.createReportParameter();
                parameter.setName( entry.getKey() );
                parameter.getValue().add( entry.getValue() );
                parameters.getReportParameter().add( parameter );
            }
            request.setParameters( parameters );
        }

        JAXBElement<ReportExecutionRequest> requestJAXBElement = factory.createReportExecutionRequest( request );

        StringWriter sw = new StringWriter();
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance( ReportExecutionRequest.class );
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
            marshaller.marshal( requestJAXBElement, sw );

        } catch( JAXBException e ) {
            e.printStackTrace();
        }
        return sw.toString();
    }

    private ReportExecution getReportStatus( HttpResponse response ) {

        ReportExecution resultStatus = new ReportExecution();

        try {
            JAXBContext jc = JAXBContext.newInstance( ReportExecution.class );
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            ReportExecution reportExecution = (ReportExecution) unmarshaller.unmarshal( response.getEntity().getContent() );

            return reportExecution;

        } catch( JAXBException e ) {
            e.printStackTrace();
        } catch( IOException e ) {
            e.printStackTrace();
        }
        return resultStatus;
    }

    public File saveResponseToFile( HttpResponse response, String path, String fileFormat ) {

        if( response.getStatusLine().getStatusCode() != HttpStatus.SC_OK ) return null;

        InputStream is = null;
        try {
            is = response.getEntity().getContent();
            File result = new File( path + "." + fileFormat );
            if( !result.exists() ) result.createNewFile();
            FileOutputStream os = new FileOutputStream( result );

            byte[] buffer = new byte[1024];
            int bytesRead;
            //read from is to buffer
            while( ( bytesRead = is.read( buffer ) ) != -1 ) {
                os.write( buffer, 0, bytesRead );
            }
            is.close();
            //flush OutputStream to write any buffered data to file
            os.flush();
            os.close();

            return result;

        } catch( IOException e ) {
            e.printStackTrace();
        }
        return null;
    }

    public String getEndpointUrl() {
        return endpointUrl;
    }

    public void setEndpointUrl( String endpointUrl ) {
        this.endpointUrl = endpointUrl;
    }
}
