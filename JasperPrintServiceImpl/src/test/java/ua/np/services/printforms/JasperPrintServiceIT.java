package ua.np.services.printforms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import javax.activation.DataHandler;
import java.io.*;

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

@ContextConfiguration(locations = "classpath*:/ua.np.services.printforms/JasperPrintServiceIT-context.xml")
public class JasperPrintServiceIT extends AbstractTestNGSpringContextTests {

    @Autowired
    @Qualifier(value = "jasperPrintService")
    private JasperPrintService printService;

    @Autowired
    @Qualifier(value = "clientJasperPrintService")
    private JasperPrintService clientPrint;

    private final String TEST_FILE_PATH = ".\\JasperPrintServiceImpl\\src\\test\\resources\\ttn.pdf";

    @Test
    public void testConfiguration() {
        Assert.assertNotNull( printService, "Bean printService has not been Autowired." );
        Assert.assertNotNull(clientPrint, "Bean clientPrint has not been Autowired.");
        Assert.assertNotNull(applicationContext.getBean("endpointJasperPrintService"),"Could not find bean endpointJasperPrintService in application context. ");
    }

    @Test
    public void testGetForm(){

        String reportString = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<Structure><Value name=\"TemplateValuablePapers\"><Type>Boolean</Type><Data>false</Data></Value><Value name=\"CounterpartySenderText\"><Type>String</Type><Data>ТОВАРИСТВО З ОБМЕЖЕНОЮ ВІДПОВІДАЛЬНІСТЮ \"ПЕРША ПАЛИВНА КОМПАНІЯ\"</Data></Value>" +
                "</Structure>";


        PrintForm pf = clientPrint.getForm( reportString );
        Assert.assertNotNull( pf );
        savePrintFormInFile( pf );

        File result = new File( TEST_FILE_PATH );

        Assert.assertNotNull( result, "Expected pdf file has not been created!" );
        Assert.assertTrue( result.exists(), "Expected pdf doesn`t exists."  );
        Assert.assertTrue( result.isFile(),"Expected pdf wasn`t file." );
        Assert.assertFalse( result.isDirectory(), "Expected pdf is Directory." );
        Assert.assertTrue( result.canRead() );


    }

    @AfterClass
    public void tearDown(){
        File generated = new File( TEST_FILE_PATH );
        if( generated.exists() ) generated.delete();
    }

    private void savePrintFormInFile(PrintForm pf){

        DataHandler handler = pf.getFormData();

        try {
            InputStream is = handler.getInputStream();

            File result = new File( TEST_FILE_PATH );
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

        } catch( IOException e ) {
            e.printStackTrace();
        }

    }

}
