package ua.np.services.printforms;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2013 Nova Poshta property
 * <p/>
 * for internal use only!
 * <p/>
 * User: yushchenko.i
 * email: yushchenko.i@novaposhta.ua
 * Date: 29.11.13
 * Time: 11:58
 */
public class SAXReportDataHandler extends DefaultHandler {

    private Map<String,String> reportParams;
    private String paramName;
    private String paramValue;
    private String startedElement;
    String content;

    @Override
    //Triggered when the start of tag is found.
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) throws SAXException {

        if( reportParams == null ) reportParams = new HashMap<>(  );
        content = null;
        startedElement = qName;
        if( qName.equals( "Value" ) ){
            paramName = attributes.getValue( "name" );
        }

    }

    @Override
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {

        paramValue = null;

        if( qName.equals( "Data" ) && content != null ){
            paramValue = content;
            reportParams.put( paramName, paramValue );
        }

    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {


        content = String.copyValueOf(ch, start, length).trim();
    }

    public Map<String, String> getReportParams() {

        if( reportParams == null )
            return Collections.emptyMap();

        return reportParams;
    }
}
