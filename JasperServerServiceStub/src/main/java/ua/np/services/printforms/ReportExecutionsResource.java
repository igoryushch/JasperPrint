/**
 * Created by Apache CXF WadlToJava code generator
**/
package ua.np.services.printforms;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/reportExecutions")
public class ReportExecutionsResource {

    @GET
    @Produces({"application/xml", "application/json" })
    public Response getReportsRuntimeInformation(@QueryParam("reportURI") String reportURI, @QueryParam("jobID") String jobID, @QueryParam("jobLabel") String jobLabel, @QueryParam("userName") String userName, 
                @QueryParam("fireTimeFrom") String fireTimeFrom, @QueryParam("fireTimeTo") String fireTimeTo) {
        //TODO: implement
        return null;
    }

    @POST
    @Consumes("*/*")
    @Produces({"application/xml", "application/json" })
    public Response getReportOutputMetadata() {
        //TODO: implement
        return null;
    }

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{executionId}/exports")
    public Response export(@PathParam("executionId") String executionId) {
        //TODO: implement
        return null;
    }

    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{executionId}/status")
    public Response cancelReportExecution(@PathParam("executionId") String executionId) {
        //TODO: implement
        return null;
    }

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{executionId}/status")
    public Response getReportExecutionStatus(@PathParam("executionId") String executionId) {
        //TODO: implement
        return null;
    }

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{executionId}")
    public Response getReportExecution(@PathParam("executionId") String executionId) {
        //TODO: implement
        return null;
    }

    @GET
    @Produces("*/*")
    @Path("/{executionId}/exports/{exportOutput}/outputResource")
    public Response getOutputResource(@PathParam("executionId") String executionId, @PathParam("exportOutput") String exportOutput) {
        //TODO: implement
        return null;
    }

    @GET
    @Produces("*/*")
    @Path("/{executionId}/exports/{exportOutput}/attachments/{attachment}")
    public Response getAttachment(@PathParam("executionId") String executionId, @PathParam("attachment") String attachment, @PathParam("exportOutput") String exportOutput) {
        //TODO: implement
        return null;
    }

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{executionId}/exports/{exportOutput}/status")
    public Response getExportExecutionStatus(@PathParam("executionId") String executionId, @PathParam("exportOutput") String exportOutput) {
        //TODO: implement
        return null;
    }

}