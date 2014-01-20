package ua.np.services.printforms;

import com.sun.xml.internal.ws.util.ByteArrayDataSource;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.xml.sax.SAXException;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.Map;

/**
 * Copyright (C) 2013 Nova Poshta. All rights reserved.
 * http://novaposhta.ua/
 * <p/>
 * for internal use only!
 * <p/>
 * User: yushchenko.i
 * email: yushchenko.i@novaposhta.ua
 * Date: 26.12.13
 */


public class JasperPrintServiceImpl implements JasperPrintService{

    private JasperServerRestClient jasperInternalClient;
    private final static String FILE_FORMAT = "pdf";

    @Override
    public PrintForm getForm( String xmlParamString ) {

        Report report = buildReportFromRequest( xmlParamString );
        HttpResponse reportResponse = jasperInternalClient.runReport( report );

        DataSource source = new ByteArrayDataSource(getByteData( reportResponse ),"content/type");

        PrintForm printForm = new PrintForm();
        printForm.setFormData( new DataHandler( source ) );

        return printForm;
    }

    private  byte[] getByteData(HttpResponse reportResponse){

        if( reportResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK ) return null;

        try {
            InputStream is = reportResponse.getEntity().getContent();
            return IOUtils.toByteArray(is);
        } catch( IOException e ) {
            e.printStackTrace();
        }
        return new byte[] {};

    }

    private Report buildReportFromRequest(String requestString){

        if (requestString != null) {

            Report report = new Report();
            report.setReportPath( "/PrintForms/ttn2" );
            report.setOutputFormat( FILE_FORMAT );

            SAXParserFactory parserFactor = SAXParserFactory.newInstance();
            SAXParser parser = null;
            try {
                parser = parserFactor.newSAXParser();
                SAXReportDataHandler handler = new SAXReportDataHandler();

                parser.parse( IOUtils.toInputStream( requestString ), handler);

                Map<String,String> reportParams = handler.getReportParams();

                for( Map.Entry<String, String> entry : reportParams.entrySet() ) {
                    report.addParameter( entry.getKey(), entry.getValue() );
                }
                return report;
            } catch( ParserConfigurationException e ) {
                e.printStackTrace();
            } catch( SAXException e ) {
                e.printStackTrace();
            } catch( IOException e ) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setJasperInternalClient( JasperServerRestClient jasperInternalClient ) {
        this.jasperInternalClient = jasperInternalClient;
    }


}
