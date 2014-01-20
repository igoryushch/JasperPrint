package ua.np.services.printforms;

/**
 * Copyright 2013 Nova Poshta property
 * <p/>
 * for internal use only!
 * <p/>
 * User: yushchenko.i
 * email: yushchenko.i@novaposhta.ua
 * Date: 25.11.13
 * Time: 16:33
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exports")
public class ExportsWrapper {

    private List<ExportEntry> exports;

    public List<ExportEntry> getExports () {
        if (exports == null) {
            exports = new ArrayList<ExportEntry> ();
        }
        return this.exports;
    }
}
