package com.challenge.challenge.web.rest;

import com.challenge.challenge.domain.exceptions.HttpException;
import com.challenge.challenge.domain.responses.SumZoneTrips;
import com.challenge.challenge.domain.responses.TopZones;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;

public interface StatisticResource {

    @RequestMapping(
            path = {"/top-zones"},
            produces = {"application/json"},
            method = {RequestMethod.GET}
    )
    ResponseEntity<TopZones> topZones(@RequestParam(name = "order") String order) throws HttpException;

    @RequestMapping(
            path = {"/zone-trips"},
            produces = {"application/json"},
            method = {RequestMethod.GET}
    )
    ResponseEntity<SumZoneTrips> zoneTrips(@RequestParam(name = "zone") Long zone, @RequestParam(name = "date") Instant date);


    // ToDo
    @RequestMapping(
            path = {"/list-yellow"},
            produces = {"application/json"},
            method = {RequestMethod.GET}
    )
    ResponseEntity<Object> listYellow();
}
