package com.nerdoria;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpeedRequest {
    @JsonProperty("spaceship_speed")
    public double speed;

    public SpeedRequest() {}

    public SpeedRequest(double speed) {
        this.speed = speed;
    }
}
