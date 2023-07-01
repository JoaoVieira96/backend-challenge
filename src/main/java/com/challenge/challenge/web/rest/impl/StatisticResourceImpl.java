package com.challenge.challenge.web.rest.impl;

import com.challenge.challenge.domain.exceptions.HttpException;
import com.challenge.challenge.domain.exceptions.error.HttpError;
import com.challenge.challenge.domain.responses.SumZoneTrips;
import com.challenge.challenge.domain.responses.TopZones;
import com.challenge.challenge.service.StatisticService;
import com.challenge.challenge.web.rest.StatisticResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api/v1")
public class StatisticResourceImpl implements StatisticResource {

    private final Logger log = LoggerFactory.getLogger(StatisticResourceImpl.class);
    @Autowired
    private StatisticService statisticService;

    @Override
    public ResponseEntity<TopZones> topZones(String order) {
        log.info("topZones | REST request to list the first 5 top zones based on [{}]", order);

        return null;
    }

    @Override
    public ResponseEntity<SumZoneTrips> zoneTrips(Long zone, Instant date) {
        log.info("zoneTrips | REST request to calculate pickups and drop-offs on zone [{}] on date [{}]", zone, date.toString());

        return null;
    }

    @Override
    public ResponseEntity<Object> listYellow() {
        log.info("listYellow | REST request to evaluate data on yellow trips");

        return null;
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<HttpError> handleAuthentication(HttpException e) {
        return ResponseEntity.status(e.getStatus()).body(new HttpError(e.getStatus(), e.getMessage(), e.getDescription()));
    }

}
