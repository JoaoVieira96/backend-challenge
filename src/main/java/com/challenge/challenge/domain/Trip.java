package com.challenge.challenge.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Trip {

    @Id
    private Long id;
    @Column(name = "pick-up-id")
    private Long pickUpId;
    @Column(name = "drop-off-id")
    private Long dropOffId;
    @Column(name = "pick-up-date")
    private Instant pickUpDate;
    @Column(name = "drop-off-date")
    private Instant dropOffDate;

}
