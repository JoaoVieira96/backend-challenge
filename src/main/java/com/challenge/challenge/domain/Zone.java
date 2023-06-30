package com.challenge.challenge.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Zone {

    @Id
    private Long id;
    @Column(name = "borough")
    private String borough;
    @Column(name = "zone")
    private String zone;
    @Column(name = "service_zone")
    private String serviceZone;

}
