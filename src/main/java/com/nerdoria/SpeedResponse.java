package com.nerdoria;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpeedResponse {
    @JsonAlias("ack_flag")
    public String flag;
}
