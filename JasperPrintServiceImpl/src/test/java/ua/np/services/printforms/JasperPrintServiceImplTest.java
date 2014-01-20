package ua.np.services.printforms;

import org.testng.annotations.Test;

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
public class JasperPrintServiceImplTest {

    private final static String ENDPOINT_ADDRESS = "http://localhost:8070/jasperserver/rest_v2/reportExecutions";

    @Test
    public void testGetForm(){

//        Report report = new Report();
//
//        String reportString = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
//                "<Structure><Value name=\"TemplateValuablePapers\"><Type>Boolean</Type><Data>false</Data></Value><Value name=\"CounterpartySenderText\"><Type>String</Type><Data>ТОВАРИСТВО З ОБМЕЖЕНОЮ ВІДПОВІДАЛЬНІСТЮ \"ПЕРША ПАЛИВНА КОМПАНІЯ\"</Data></Value>" +
//                "</Structure>";
//
//        JasperServerRestClient mockJasperInternalClient = mock(JasperServerRestClient.class);
//
//        HttpResponse response = new BasicHttpResponse( new ProtocolVersion( "HTTP",1,1 ),200,"123" );
//
//        JasperPrintServiceImpl jasperPrintService = new JasperPrintServiceImpl();
//        jasperPrintService.setJasperInternalClient( mockJasperInternalClient );
//        when( mockJasperInternalClient.runReport( report ) ).thenReturn( response );
//
//        jasperPrintService.getForm( reportString );
//
//        verify( mockJasperInternalClient, times( 1 ) ).runReport( report );

    }

}
