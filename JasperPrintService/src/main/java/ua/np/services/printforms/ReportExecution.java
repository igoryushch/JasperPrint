package ua.np.services.printforms; /**
 * Copyright 2013 Nova Poshta property
 * <p/>
 * for internal use only!
 * <p/>
 * User: yushchenko.i
 * email: yushchenko.i@novaposhta.ua
 * Date: 25.11.13
 * Time: 15:34
 */

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class ReportExecution {

    @XmlElementWrapper
    @XmlElement(name="export")
    private List<ExportEntry> exports;
    private String reportURI;
    private String requestId;
    private String status;
    private String totalPages;

    public ReportExecution () {
        this ( "", "", "none", "0" );
    }

    public ReportExecution( String reportURI, String requestId, String status, String totalPages ) {
        this.reportURI = reportURI;
        this.requestId = requestId;
        this.status = status;
        this.totalPages = totalPages;

        exports = new ArrayList<>(  );
    }

    public ReportExecution( List<ExportEntry> exports, String reportURI, String requestId, String status, String totalPages ) {
        this.exports = exports;
        this.reportURI = reportURI;
        this.requestId = requestId;
        this.status = status;
        this.totalPages = totalPages;
    }

    public List<ExportEntry> getExports() {
        return exports;
    }

    public void setExports( List<ExportEntry> exports ) {
        this.exports = exports;
    }

    public String getReportURI() {
        return reportURI;
    }

    public void setReportURI( String reportURI ) {
        this.reportURI = reportURI;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId( String requestId ) {
        this.requestId = requestId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public void setTotalPages( String totalPages ) {
        this.totalPages = totalPages;
    }
}
