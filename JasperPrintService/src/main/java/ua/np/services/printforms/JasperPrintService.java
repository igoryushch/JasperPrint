package ua.np.services.printforms;

import javax.jws.WebService;

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

@WebService(
        name = "JasperPrintService"
)
public interface JasperPrintService {

    PrintForm getForm( String xmlParamString );

}
