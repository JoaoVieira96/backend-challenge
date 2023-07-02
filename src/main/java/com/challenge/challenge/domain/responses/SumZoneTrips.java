package com.challenge.challenge.domain.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SumZoneTrips {

    private String zone;
    private String date;
    @JsonProperty("pu")
    private Long pickUps;
    @JsonProperty("po")
    private Long dropOffs;
}
