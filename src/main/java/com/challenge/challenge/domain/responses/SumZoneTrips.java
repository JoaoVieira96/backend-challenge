package com.challenge.challenge.domain.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SumZoneTrips {

    private String zone;
    private Instant date;
    @JsonProperty("pu")
    private Long pickUps;
    @JsonProperty("po")
    private Long dropOffs;
}
