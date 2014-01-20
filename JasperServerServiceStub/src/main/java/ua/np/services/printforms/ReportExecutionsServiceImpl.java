/**
 * Created by Apache CXF WadlToJava code generator
**/
package ua.np.services.printforms;

import org.apache.cxf.helpers.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.entity.InputStreamEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

@Service
@Path("/reportExecutions")
public class ReportExecutionsServiceImpl implements ReportExecutionsService {

    private static final String REPORT_ID = "677629003_1355225037212_1";    // just copied from book
    private static final String FILE_OUTPUT_PATH = "JasperServerServiceStub\\src\\test\\resources\\DemoTest_plain.pdf";

    @GET
    @Produces({"application/xml", "application/json" })
    public Response getReportsRuntimeInformation(@QueryParam("reportURI") String reportURI,
                                                 @QueryParam("jobID") String jobID,
                                                 @QueryParam("jobLabel") String jobLabel,
                                                 @QueryParam("userName") String userName,
                                                 @QueryParam("fireTimeFrom") String fireTimeFrom,
                                                 @QueryParam("fireTimeTo") String fireTimeTo) {
        //TODO: implement
        return Response.status( 404 ).build();
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getReportOutputMetadata( @Context final HttpServletRequest request ) {

       HttpEntity entity = null;

        try {
            entity = new InputStreamEntity(request.getInputStream(), request.getContentLength());
            JAXBContext jc = JAXBContext.newInstance( ua.np.services.printforms.ReportExecutionRequest.class );
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            ReportExecutionRequest reportExecutionRequest = (ReportExecutionRequest) unmarshaller.unmarshal( entity.getContent() );

            OutputResource resource = new OutputResource();
            resource.setContentType( new ArrayList<String>(1) );
            resource.getContentType().add( "application/xml" );

            ExportEntry ee = new ExportEntry( reportExecutionRequest.getOutputFormat(),
                                              resource,"ready");

            ReportExecution re = new ReportExecution( reportExecutionRequest.getReportUnitUri(),
                                                      REPORT_ID, "ready", "1" );
            re.getExports().add( ee );

            return Response.ok( re ).build();

        } catch( IOException e ) {
            e.printStackTrace();
        } catch( JAXBException e ) {
            e.printStackTrace();
        }

        return Response.serverError().build();

    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{executionId}/exports")
    public Response export(@PathParam("executionId") String executionId) {
        //TODO: implement
        return Response.status( 404 ).build();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{executionId}/status")
    public Response cancelReportExecution(@PathParam("executionId") String executionId) {
        //TODO: implement
        return Response.status( 404 ).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{executionId}/status")
    public Response getReportExecutionStatus(@PathParam("executionId") String executionId) {
        //TODO: implement
        return Response.status( 404 ).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{executionId}")
    public Response getReportExecution(@PathParam("executionId") String executionId) {
        //TODO: implement
        return Response.status( 404 ).build();
    }

    @GET
    @Produces("*/*")
    @Path("/{executionId}/exports/{exportOutput}/outputResource")
    public Response getOutputResource(@PathParam("executionId") String executionId,
                                      @PathParam("exportOutput") String exportOutput) {

        if( REPORT_ID.equals( executionId ) && "pdf".equals( exportOutput )){

            try {

                return Response.ok( IOUtils.readBytesFromStream( new FileInputStream( FILE_OUTPUT_PATH ) ) ,
                                                                 "application/pdf")
                                                                .build();

            } catch( IOException e ) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        }


        return Response.status( 400 ).build();  // Bad Request
    }

    @GET
    @Produces("*/*")
    @Path("/{executionId}/exports/{exportOutput}/attachments/{attachment}")
    public Response getAttachment(@PathParam("executionId") String executionId,
                                  @PathParam("attachment") String attachment,
                                  @PathParam("exportOutput") String exportOutput) {
        //TODO: implement
        return Response.status( 404 ).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{executionId}/exports/{exportOutput}/status")
    public Response getExportExecutionStatus(@PathParam("executionId") String executionId,
                                             @PathParam("exportOutput") String exportOutput) {
        //TODO: implement
        return Response.status( 404 ).build();
    }

}