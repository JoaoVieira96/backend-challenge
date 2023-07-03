package com.challenge.challenge.web.rest.impl;

import com.challenge.challenge.domain.responses.SumZoneTrips;
import com.challenge.challenge.domain.responses.TopZones;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StatisticResourceImplTest {
    @Autowired
    private StatisticResourceImpl statisticResource;


    // Preberably I would have an independent DB and I would have meanings to create configurations but since
    // that wasn't in the scope of this challenge I'll use the same database and the pre loaded values
    @SneakyThrows
    @Test
    void topZones() {
        ResponseEntity<TopZones> response = statisticResource.topZones("dropoffs");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        TopZones topZones = response.getBody();

        assertEquals(5, topZones.getZoneTotalList().size());
        assertEquals("Gramercy", topZones.getZoneTotalList().get(0).getZone());
        assertEquals(22L, topZones.getZoneTotalList().get(0).getPuTotal());
        assertEquals(26L, topZones.getZoneTotalList().get(0).getDoTotal());
    }

    @SneakyThrows
    @Test
    void zoneTrips() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
        Date date = formatter.parse("01-01-2023");
        ResponseEntity<SumZoneTrips> response = statisticResource.zoneTrips(1L, date);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        SumZoneTrips sumZoneTrips = response.getBody();
        assertEquals("Newark Airport", sumZoneTrips.getZone());
        assertEquals(552L, sumZoneTrips.getPickUps());
        assertEquals(539L, sumZoneTrips.getDropOffs());

    }
}
