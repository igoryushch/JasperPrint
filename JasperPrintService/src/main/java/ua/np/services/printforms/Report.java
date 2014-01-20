package ua.np.services.printforms;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2013 Nova Poshta property
 * <p/>
 * for internal use only!
 * <p/>
 * User: yushchenko.i
 * email: yushchenko.i@novaposhta.ua
 * Date: 25.11.13
 * Time: 16:52
 */
public class Report {

    private String reportPath;
    private String outputFormat;
    private Map<String, String> params;

    public Report () {
        params = new HashMap<> (  );
    }

    public String getReportPath () {
        return reportPath;
    }

    public void setReportPath ( String reportPath ) {
        this.reportPath = reportPath;
    }

    public String getOutputFormat () {
        return outputFormat;
    }

    public void setOutputFormat ( String outputFormat ) {
        this.outputFormat = outputFormat;
    }

    public Map<String, String> getParams () {
        return params;
    }

    public void setParams ( Map<String, String> params ) {
        this.params = params;
    }

    public void addParameter(String key, String value) {
        params.put(key, value);
    }
}
