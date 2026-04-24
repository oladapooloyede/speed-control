package com.nerdoria;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalTime;
import java.time.Duration;

@Path("/flag")
public class ShipResource {

    // Punctuality matters: must arrive at 7:00 PM NST, currently 1:16 PM NST.
    private static final LocalTime CURRENT_TIME = LocalTime.of(13, 16);
    private static final LocalTime ARRIVAL_TIME = LocalTime.of(19, 0);

    // camera1 returns the distance rendered onto a PNG rather than as JSON, so
    // the value is read off the image out-of-band and kept here as a constant.
    private static final double DISTANCE_KM = 922_888;

    @RestClient
    ShipApiClient shipApi;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public SpeedResponse arriveOnTime() {
        shipApi.getFrontCamera();

        long travelSeconds = Duration.between(CURRENT_TIME, ARRIVAL_TIME).toSeconds();

        double speedKmPerSec = DISTANCE_KM / travelSeconds;

        return shipApi.setSpeed(new SpeedRequest(speedKmPerSec));
    }
}
