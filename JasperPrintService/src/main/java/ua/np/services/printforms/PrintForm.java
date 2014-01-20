package ua.np.services.printforms;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;

/**
 * Copyright (C) 2013 Nova Poshta. All rights reserved.
 * http://novaposhta.ua/
 * <p/>
 * for internal use only!
 * <p/>
 * User: yushchenko.i
 * email: yushchenko.i@novaposhta.ua
 * Date: 27.12.13
 */

@XmlType
public class PrintForm {


    private DataHandler formData;

    public DataHandler getFormData() {
        return formData;
    }

    @XmlMimeType("application/octet-stream")
    public void setFormData( DataHandler formData ) {
        this.formData = formData;
    }
}
