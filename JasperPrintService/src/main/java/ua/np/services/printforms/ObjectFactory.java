
package ua.np.services.printforms;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SimpleTrigger_QNAME = new QName("", "simpleTrigger");
    private final static QName _ReportParameter_QNAME = new QName("", "reportParameter");
    private final static QName _Parameters_QNAME = new QName("", "parameters");
    private final static QName _ReportExecutionRequest_QNAME = new QName("", "reportExecutionRequest");
    private final static QName _ServerInfo_QNAME = new QName("", "serverInfo");
    private final static QName _Export_QNAME = new QName("", "export");
    private final static QName _Status_QNAME = new QName("", "status");
    private final static QName _ReportParameters_QNAME = new QName("", "reportParameters");
    private final static QName _CalendarTrigger_QNAME = new QName("", "calendarTrigger");
    private final static QName _ReportExecution_QNAME = new QName("", "reportExecution");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReportParametersMapWrapper }
     * 
     */
    public ReportParametersMapWrapper createReportParametersMapWrapper() {
        return new ReportParametersMapWrapper();
    }

    /**
     * Create an instance of {@link ReportParametersMapWrapper.ParameterValues }
     * 
     */
    public ReportParametersMapWrapper.ParameterValues createReportParametersMapWrapperParameterValues() {
        return new ReportParametersMapWrapper.ParameterValues();
    }

    /**
     * Create an instance of {@link ReportParameter }
     * 
     */
    public ReportParameter createReportParameter() {
        return new ReportParameter();
    }

    /**
     * Create an instance of {@link ReportExecutionRequest }
     * 
     */
    public ReportExecutionRequest createReportExecutionRequest() {
        return new ReportExecutionRequest();
    }

    public ReportExecution createReportExecution() {
        return new ReportExecution();
    }

    /**
     * Create an instance of {@link ReportParameters }
     * 
     */
    public ReportParameters createReportParameters() {
        return new ReportParameters();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "simpleTrigger")
    public JAXBElement<Object> createSimpleTrigger(Object value) {
        return new JAXBElement<Object>(_SimpleTrigger_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "reportParameter")
    public JAXBElement<ReportParameter> createReportParameter(ReportParameter value) {
        return new JAXBElement<ReportParameter>(_ReportParameter_QNAME, ReportParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportParametersMapWrapper }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "parameters")
    public JAXBElement<ReportParametersMapWrapper> createParameters(ReportParametersMapWrapper value) {
        return new JAXBElement<ReportParametersMapWrapper>(_Parameters_QNAME, ReportParametersMapWrapper.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportExecutionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "reportExecutionRequest")
    public JAXBElement<ReportExecutionRequest> createReportExecutionRequest(ReportExecutionRequest value) {
        return new JAXBElement<ReportExecutionRequest>(_ReportExecutionRequest_QNAME, ReportExecutionRequest.class, null, value);
    }

    @XmlElementDecl(namespace = "", name = "serverInfo")
    public JAXBElement<ServerInfo> createServerInfo(ServerInfo value) {
        return new JAXBElement<ServerInfo>(_ServerInfo_QNAME, ServerInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "export")
    public JAXBElement<Object> createExport(Object value) {
        return new JAXBElement<Object>(_Export_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "status")
    public JAXBElement<String> createStatus(String value) {
        return new JAXBElement<String>(_Status_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "reportParameters")
    public JAXBElement<ReportParameters> createReportParameters(ReportParameters value) {
        return new JAXBElement<ReportParameters>(_ReportParameters_QNAME, ReportParameters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "calendarTrigger")
    public JAXBElement<Object> createCalendarTrigger(Object value) {
        return new JAXBElement<Object>(_CalendarTrigger_QNAME, Object.class, null, value);
    }

    @XmlElementDecl(namespace = "", name = "reportExecution")
    public JAXBElement<Object> createReportExecution(Object value) {
        return new JAXBElement<Object>(_ReportExecution_QNAME, Object.class, null, value);
    }
}
