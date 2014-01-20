package ua.np.services.printforms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Copyright 2013 Nova Poshta property
 * <p/>
 * for internal use only!
 * <p/>
 * User: yushchenko.i
 * email: yushchenko.i@novaposhta.ua
 * Date: 25.11.13
 * Time: 15:37
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "export")
public class ExportEntry {

    private String id;
    private OutputResource outputResource;
    private String status;

    public ExportEntry() {
    }

    public ExportEntry( String id, OutputResource outputResource, String status ) {
        this.id = id;
        this.outputResource = outputResource;
        this.status = status;
    }

    public String getId () {
        return id;
    }

    public void setId ( String id ) {
        this.id = id;
    }

    public OutputResource getOutputResource () {
        return outputResource;
    }

    public void setOutputResource ( OutputResource outputResource ) {
        this.outputResource = outputResource;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus ( String status ) {
        this.status = status;
    }
}
