package ua.np.services.printforms;

import javax.xml.bind.annotation.*;

/**
 * Copyright 2013 Nova Poshta property
 * <p/>
 * for internal use only!
 * <p/>
 * User: yushchenko.i
 * email: yushchenko.i@novaposhta.ua
 * Date: 20.11.13
 * Time: 10:45
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serverInfo", propOrder = {
        "build",
        "dateFormatPattern",
        "datetimeFormatPattern",
        "edition",
        "editionName",
        "expiration",
        "features",
        "licenseType",
        "version",
})
public class ServerInfo {

    private String features = "Fusion AHD EXP DB ANA AUD MT ";
    private String version = "5.5.0";
    private String edition = "PRO";
    private String editionName = "Enterprise";
    private String licenseType = "Evaluation";
    private String build = "20131024_0554";
    private String expiration = "";
    private String dateFormatPattern = "yyyy-MM-dd";
    private String datetimeFormatPattern = "yyyy-MM-dd HH:mm:ss";

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getEditionName() {
        return editionName;
    }

    public void setEditionName(String editionName) {
        this.editionName = editionName;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getDateFormatPattern() {
        return dateFormatPattern;
    }

    public void setDateFormatPattern(String dateFormatPattern) {
        this.dateFormatPattern = dateFormatPattern;
    }

    public String getDatetimeFormatPattern() {
        return datetimeFormatPattern;
    }

    public void setDatetimeFormatPattern(String datetimeFormatPattern) {
        this.datetimeFormatPattern = datetimeFormatPattern;
    }
}
