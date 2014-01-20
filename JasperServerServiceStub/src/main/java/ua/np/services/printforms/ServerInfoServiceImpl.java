package ua.np.services.printforms;

/**
 * Copyright 2013 Nova Poshta property
 * <p/>
 * for internal use only!
 * <p/>
 * User: yushchenko.i
 * email: yushchenko.i@novaposhta.ua
 * Date: 20.11.13
 * Time: 9:16
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

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/serverInfo")
public class ServerInfoServiceImpl implements ServerInfoService {

    ServerInfo serverInfo = new ServerInfo ();

    @GET
    @Produces("application/xml")
    public Response getServerInfo () {

        Response response = Response.ok ( serverInfo ).build ();
        return response;
    }

    @GET
    @Produces("text/plain")
    @Path("/features")
    public String getFeatures () {
        return serverInfo.getFeatures ();
    }

    @GET
    @Produces("text/plain")
    @Path("/version")
    public String getServerVersion () {
        return serverInfo.getVersion ();
    }

    @GET
    @Produces("text/plain")
    @Path("/edition")
    public String getServerEdition () {
        return serverInfo.getEdition ();
    }

    @GET
    @Produces("text/plain")
    @Path("/editionName")
    public String getServerEditionName () {
        return serverInfo.getEditionName ();
    }

    @GET
    @Produces("text/plain")
    @Path("/licenseType")
    public String getServerLicenseType () {
        return serverInfo.getLicenseType ();
    }

    @GET
    @Produces("text/plain")
    @Path("/build")
    public String getServerBuild () {
        return serverInfo.getBuild ();
    }

    @GET
    @Produces("text/plain")
    @Path("/expiration")
    public String getServerExpiration () {
        return serverInfo.getExpiration ();
    }

    @GET
    @Produces("text/plain")
    @Path("/dateFormatPattern")
    public String dateFormatPattern () {
        return serverInfo.getDateFormatPattern ();
    }

    @GET
    @Produces("text/plain")
    @Path("/datetimeFormatPattern")
    public String datetimeFormatPattern () {
        return serverInfo.getDatetimeFormatPattern ();
    }
}
