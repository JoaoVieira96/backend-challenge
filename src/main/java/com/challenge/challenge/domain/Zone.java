package com.challenge.challenge.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


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
