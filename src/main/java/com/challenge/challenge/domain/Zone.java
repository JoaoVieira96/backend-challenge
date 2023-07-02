package com.challenge.challenge.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "zone")
public class Zone {

    @Id
    private Long id;
    @Column(name = "borough")
    private String borough;
    @Column(name = "zone")
    private String zone;
    @Column(name = "service_zone")
    @JsonProperty("service_zone")
    private String serviceZone;

}
