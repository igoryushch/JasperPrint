/**
 * Created by Apache CXF WadlToJava code generator
**/
package ua.np.services.printforms;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/reports")
public class ReportsResource {

    @GET
    @Produces({"application/xml", "application/json" })
    public Response getReportsRuntimeInformation(@QueryParam("reportURI") String reportURI, @QueryParam("jobID") String jobID, @QueryParam("jobLabel") String jobLabel, @QueryParam("userName") String userName, 
                @QueryParam("fireTimeFrom") String fireTimeFrom, @QueryParam("fireTimeTo") String fireTimeTo) {
        //TODO: implement
        return null;
    }

    @GET
    @Produces("*/*")
    @Path("/{reportUnitURI: .+}.{outputFormat}")
    public Response getReportOutputResource(@PathParam("outputFormat") String outputFormat, @PathParam("reportUnitURI") String reportUnitURI, @QueryParam("page") Integer page, @QueryParam("pages") String pages, 
                @QueryParam("transformerKey") String transformerKey, @QueryParam("ignorePagination") @DefaultValue("false") Boolean ignorePagination, @QueryParam("attachmentsPrefix") String attachmentsPrefix, @QueryParam("freshData") @DefaultValue("false") Boolean freshData, 
                @QueryParam("interactive") @DefaultValue("true") Boolean interactive, @QueryParam("saveDataSnapshot") @DefaultValue("false") Boolean saveDataSnapshot) {
        //TODO: implement
        return null;
    }

    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces("*/*")
    @Path("/{executionId}/status")
    public Response cancelReportExecution(@PathParam("executionId") String executionId) {
        //TODO: implement
        return null;
    }

}