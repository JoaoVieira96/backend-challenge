package com.challenge.challenge.domain.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ZoneTotal {

    private String zone;
    @JsonProperty("pu_total")
    private Long puTotal;
    @JsonProperty("do_total")
    private Long doTotal;
}
