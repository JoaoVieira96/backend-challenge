package com.challenge.challenge.domain.responses;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TopZones {
    List<ZoneTotal> zoneTotalList;
}
