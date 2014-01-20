package ua.np.services.printforms;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Copyright 2013 Nova Poshta property
 * <p/>
 * for internal use only!
 * <p/>
 * User: yushchenko.i
 * email: yushchenko.i@novaposhta.ua
 * Date: 21.11.13
 * Time: 14:13
 */

@Path("/reports")
public interface ReportService {

    @GET
    @Produces({"application/xml", "application/json" })
    public Response getReportsRuntimeInformation(@QueryParam("reportURI") String reportURI, @QueryParam("jobID") String jobID,
                                                 @QueryParam("jobLabel") String jobLabel, @QueryParam("userName") String userName,
                                                 @QueryParam("fireTimeFrom") String fireTimeFrom, @QueryParam("fireTimeTo") String fireTimeTo);

    @GET
    @Produces("*/*")
    @Path("/{reportUnitURI: .+}.{outputFormat}")
    public Response getReportOutputResource(@PathParam("outputFormat") String outputFormat, @PathParam("reportUnitURI") String reportUnitURI);


    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces("*/*")
    @Path("/{executionId}/status")
    public Response cancelReportExecution(@PathParam("executionId") String executionId);


}
