package com.nerdoria;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "ship-api")
@Path("/api/v1")
public interface ShipApiClient {

    @GET
    @Path("/camera1")
    @Produces("image/png")
    byte[] getFrontCamera();

    @POST
    @Path("/speed")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    SpeedResponse setSpeed(SpeedRequest request);
}
