package ua.np.services.printforms;

/**
 * Copyright 2013 Nova Poshta property
 * <p/>
 * for internal use only!
 * <p/>
 * User: yushchenko.i
 * email: yushchenko.i@novaposhta.ua
 * Date: 20.11.13
 * Time: 11:48
 */

/*
*  Use the following service to verify the server information
*
*  The server returns a structure containing the information in the requested format, XML or JSON:
*
*    <serverInfo>
*        <build>20121029_1532</build>
*        <edition>PRO</edition>
*        <editionName>Enterprise</editionName>
*        <expiration/>
*        <features>Fusion AHD EXP DB AUD ANA MT</features>
*        <licenseType>Commercial</licenseType>
*        <version>5.0.0</version>
*    </serverInfo>
*
* */

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/serverInfo")
@WebService
public interface ServerInfoService {

    @GET
    @Produces({"application/xml", "application/json" })
    public Response getServerInfo();

    @GET
    @Produces("text/plain")
    @Path("/features")
    public String getFeatures();

    @GET
    @Produces("text/plain")
    @Path("/version")
    public String getServerVersion();

    @GET
    @Produces("text/plain")
    @Path("/edition")
    public String getServerEdition();

    @GET
    @Produces("text/plain")
    @Path("/editionName")
    public String getServerEditionName();

    @GET
    @Produces("text/plain")
    @Path("/licenseType")
    public String getServerLicenseType();

    @GET
    @Produces("text/plain")
    @Path("/build")
    public String getServerBuild();

    @GET
    @Produces("text/plain")
    @Path("/expiration")
    public String getServerExpiration();

    @GET
    @Produces("text/plain")
    @Path("/dateFormatPattern")
    public String dateFormatPattern();

    @GET
    @Produces("text/plain")
    @Path("/datetimeFormatPattern")
    public String datetimeFormatPattern();
}
