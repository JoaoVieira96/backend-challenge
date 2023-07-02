package com.challenge.challenge.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trip")
public class Trip {

    @Id
    private Long id;
    @Column(name = "pick_up_id")
    private Long pickUpId;
    @Column(name = "drop_off_id")
    private Long dropOffId;
    @Column(name = "pick_up_date")
    private Instant pickUpDate;
    @Column(name = "drop_off_date")
    private Instant dropOffDate;

}
