
package ua.np.services.printforms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for reportExecutionRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reportExecutionRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="async" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="attachmentsPrefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="freshData" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ignorePagination" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="interactive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="outputFormat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pages" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parameters" type="{}reportParameters" minOccurs="0"/>
 *         &lt;element name="reportUnitUri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="saveDataSnapshot" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="transformerKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "reportExecutionRequest")
@XmlType(name = "reportExecutionRequest", propOrder = {
        "reportUnitUri",
        "async",
        "attachmentsPrefix",
        "freshData",
        "ignorePagination",
        "interactive",
        "outputFormat",
        "pages",
        "parameters",
        "saveDataSnapshot",
        "transformerKey"
})
public class ReportExecutionRequest {

    protected Boolean async;
    protected String attachmentsPrefix;
    protected Boolean freshData;
    protected Boolean ignorePagination;
    protected Boolean interactive;
    protected String outputFormat;
    protected String pages;
    protected ReportParameters parameters;
    protected String reportUnitUri;
    protected Boolean saveDataSnapshot;
    protected String transformerKey;

    public ReportExecutionRequest() {
    }

    public ReportExecutionRequest( Boolean async,
                                   String attachmentsPrefix,
                                   Boolean freshData,
                                   Boolean ignorePagination,
                                   Boolean interactive,
                                   String outputFormat,
                                   String pages,
                                   ReportParameters parameters,
                                   String reportUnitUri,
                                   Boolean saveDataSnapshot,
                                   String transformerKey ) {
        this.async = async;
        this.attachmentsPrefix = attachmentsPrefix;
        this.freshData = freshData;
        this.ignorePagination = ignorePagination;
        this.interactive = interactive;
        this.outputFormat = outputFormat;
        this.pages = pages;
        this.parameters = parameters;
        this.reportUnitUri = reportUnitUri;
        this.saveDataSnapshot = saveDataSnapshot;
        this.transformerKey = transformerKey;
    }

    /**
     * Gets the value of the async property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAsync() {
        return async;
    }

    /**
     * Sets the value of the async property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAsync(Boolean value) {
        this.async = value;
    }

    /**
     * Gets the value of the attachmentsPrefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachmentsPrefix() {
        return attachmentsPrefix;
    }

    /**
     * Sets the value of the attachmentsPrefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachmentsPrefix(String value) {
        this.attachmentsPrefix = value;
    }

    /**
     * Gets the value of the freshData property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFreshData() {
        return freshData;
    }

    /**
     * Sets the value of the freshData property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFreshData(Boolean value) {
        this.freshData = value;
    }

    /**
     * Gets the value of the ignorePagination property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIgnorePagination() {
        return ignorePagination;
    }

    /**
     * Sets the value of the ignorePagination property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIgnorePagination(Boolean value) {
        this.ignorePagination = value;
    }

    /**
     * Gets the value of the interactive property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInteractive() {
        return interactive;
    }

    /**
     * Sets the value of the interactive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInteractive(Boolean value) {
        this.interactive = value;
    }

    /**
     * Gets the value of the outputFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutputFormat() {
        return outputFormat;
    }

    /**
     * Sets the value of the outputFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutputFormat(String value) {
        this.outputFormat = value;
    }

    /**
     * Gets the value of the pages property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPages() {
        return pages;
    }

    /**
     * Sets the value of the pages property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPages(String value) {
        this.pages = value;
    }

    /**
     * Gets the value of the parameters property.
     * 
     * @return
     *     possible object is
     *     {@link ReportParameters }
     *     
     */
    public ReportParameters getParameters() {
        return parameters;
    }

    /**
     * Sets the value of the parameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportParameters }
     *     
     */
    public void setParameters(ReportParameters value) {
        this.parameters = value;
    }

    /**
     * Gets the value of the reportUnitUri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportUnitUri() {
        return reportUnitUri;
    }

    /**
     * Sets the value of the reportUnitUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportUnitUri(String value) {
        this.reportUnitUri = value;
    }

    /**
     * Gets the value of the saveDataSnapshot property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSaveDataSnapshot() {
        return saveDataSnapshot;
    }

    /**
     * Sets the value of the saveDataSnapshot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSaveDataSnapshot(Boolean value) {
        this.saveDataSnapshot = value;
    }

    /**
     * Gets the value of the transformerKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransformerKey() {
        return transformerKey;
    }

    /**
     * Sets the value of the transformerKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransformerKey(String value) {
        this.transformerKey = value;
    }

}
