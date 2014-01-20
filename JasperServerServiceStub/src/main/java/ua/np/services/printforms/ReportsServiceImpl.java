package ua.np.services.printforms;

/**
 * Copyright 2013 Nova Poshta property
 * <p/>
 * for internal use only!
 * <p/>
 * User: yushchenko.i
 * email: yushchenko.i@novaposhta.ua
 * Date: 20.11.13
 * Time: 9:28
 */

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/reports")
public class ReportsServiceImpl {

    /*
    *   /reports service provides functionality to stop reports that are running.
    *   Reports can be running from user interaction, web service calls, or scheduling.
    *   The following method provides several ways to find reports that are currently running,
    *    in case the client wants to stop them.
    *
    *   GET
    *   http://<host>:<port>/jasperserver[-pro]/rest_v2/reports/path/to/report/
    *   http://<host>:<port>/jasperserver[-pro]/rest_v2/reports?<arguments>
    *
    *   jobID?  -  Find the running report based on its jobID in the scheduler.
    *   jobLabel?  -  Find the running report based on its jobLabel in the scheduler.
    *   userName?  -  Name of user who has scheduled a report, in the format <username>%7C<organizationID>.
    *                 The |<organizationID> is required for all users except system admins (superuser).
    *
    *   fireTimeFrom? (fireTimeTo?)
    *
    *   Date and time in the following pattern: yyyy-MM-dd'T'HH:mmZ.
    *   Together, these arguments create a time range to find when the running report was started.
    *   Both of the range limits are inclusive. Either argument may be null to signify an open-ended range.
    *
    * */

    @GET
    @Produces({"application/xml", "application/json" })
    public Response getReportsRuntimeInformation(@QueryParam("reportURI") String reportURI, @QueryParam("jobID") String jobID, @QueryParam("jobLabel") String jobLabel, @QueryParam("userName") String userName,
                                                 @QueryParam("fireTimeFrom") String fireTimeFrom, @QueryParam("fireTimeTo") String fireTimeTo) {
        //TODO: implement
        return null;
    }


    /*
    *   Running a Report
    *
    *   v2/reports service allows clients to receive report output in a single request-response.
    *   The output format is specified in the URL as a file extension to the report URI.
    *
    *   GET
    *   http://<host>:<port>/jasperserver[-pro]/rest_v2/reports/path/to/report.<format>?<arguments>
    *
    *       <format>       - One of the following formats: pdf, html, xls, xlsx, rtf, csv, xml, docx, odt, ods, jprint.
    *       page?          - An integer value used to export a specific page
    *       <inputControl> - Any input control that is defined for the report. Input controls that are
    *                       multi-select may appear more than once. See examples below.
    *       The follow examples show various combinations of formats, arguments, and input controls:
    *       http://<host>:<port>/jasperserver[-pro]/rest_v2/reports/reports/samples/AllAccounts.html (all pages)
    *       http://<host>:<port>/jasperserver[-pro]/rest_v2/reports/reports/samples/AllAccounts.html?page=43
    *       http://<host>:<port>/jasperserver[-pro]/rest_v2/reports/reports/samples/AllAccounts.pdf (all pages)
    *       http://<host>:<port>/jasperserver[-pro]/rest_v2/reports/reports/samples/AllAccounts.pdf?page=1
    *       http://<host>:<port>/jasperserver[-pro]/rest_v2/reports/reports/samples/EmployeeAccounts.html?EmployeeID=sarah_id
    *       http://<host>:<port>/jasperserver[-pro]/rest_v2/reports/reports/samples/Cascading_multi_select_report.html?Country_multi_select=USA&Cascading_state_multi_select=WA&Cascading_state_multi_select=CA
    *
    *   */

    @GET
    @Produces("*/*")
    @Path("/{reportUnitURI: .+}.{outputFormat}")
    public Response getReportOutputResource(@PathParam("outputFormat") String outputFormat, @PathParam("reportUnitURI") String reportUnitURI) {
        //TODO: implement
        return null;
    }


    /*
    *   PUT
    *   http://<host>:<port>/jasperserver[-pro]/rest_v2/reports/<executionID>/status/
    *   Content-Type - application/xml
    *   Either an empty instance of the ReportExecutionCancellation class or <status>cancelled</status>.
    *
    *
    * */

    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces("*/*")
    @Path("/{executionId}/status")
    public Response cancelReportExecution(@PathParam("executionId") String executionId) {
        //TODO: implement
        return null;
    }

}
