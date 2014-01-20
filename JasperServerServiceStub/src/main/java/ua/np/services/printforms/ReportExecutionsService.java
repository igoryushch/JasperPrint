package ua.np.services.printforms;

/**
 * Copyright 2013 Nova Poshta property
 * <p/>
 * for internal use only!
 * <p/>
 * User: yushchenko.i
 * email: yushchenko.i@novaposhta.ua
 * Date: 22.11.13
 * Time: 9:50
 */

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
@Path("/reportExecutions")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface ReportExecutionsService {

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getReportsRuntimeInformation(@QueryParam("reportURI") String reportURI,
                                                 @QueryParam("jobID") String jobID,
                                                 @QueryParam("jobLabel") String jobLabel,
                                                 @QueryParam("userName") String userName,
                                                 @QueryParam("fireTimeFrom") String fireTimeFrom,
                                                 @QueryParam("fireTimeTo") String fireTimeTo);

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getReportOutputMetadata( @Context final HttpServletRequest request  );

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{executionId}/exports")
    public Response export(@PathParam("executionId") String executionId);

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{executionId}/status")
    public Response cancelReportExecution(@PathParam("executionId") String executionId);

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{executionId}/status")
    public Response getReportExecutionStatus(@PathParam("executionId") String executionId);

    @GET
    @Path("/{executionId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getReportExecution(@PathParam("executionId") String executionId);

    @GET
    @Produces("*/*")
    @Path("/{executionId}/exports/{exportOutput}/outputResource")
    public Response getOutputResource(@PathParam("executionId") String executionId,
                                      @PathParam("exportOutput") String exportOutput);

    @GET
    @Produces("*/*")
    @Path("/{executionId}/exports/{exportOutput}/attachments/{attachment}")
    public Response getAttachment(@PathParam("executionId") String executionId,
                                  @PathParam("attachment") String attachment,
                                  @PathParam("exportOutput") String exportOutput);

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{executionId}/exports/{exportOutput}/status")
    public Response getExportExecutionStatus(@PathParam("executionId") String executionId,
                                             @PathParam("exportOutput") String exportOutput);

}
