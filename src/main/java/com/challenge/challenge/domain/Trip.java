package com.challenge.challenge.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.Instant;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Trip {

    @Id
    private Long id;
    @Column(name = "pick-up")
    private Instant pickUp;
    @Column(name = "drop-off")
    private Instant dropOff;

}
