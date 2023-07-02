package com.challenge.challenge.service;

import com.challenge.challenge.domain.Trip;
import com.challenge.challenge.domain.Zone;
import com.challenge.challenge.domain.exceptions.HttpException;
import com.challenge.challenge.domain.responses.SumZoneTrips;
import com.challenge.challenge.domain.responses.TopZones;
import com.challenge.challenge.domain.responses.ZoneTotal;
import com.challenge.challenge.repository.TripRepository;
import com.challenge.challenge.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StatisticService {

    @Autowired
    private ZoneRepository zoneRepository;

    @Autowired
    private TripRepository tripRepository;

    public ResponseEntity<TopZones> topZones(String order) throws HttpException {
        TopZones topZones = new TopZones();
        if (order.equals("pickups")) {
            List<ZoneTotal> zoneTotalList = new ArrayList<>();
            List<Map<String, Object>> repoTotalList = tripRepository.findBestPickups(PageRequest.of(0, 5));

            repoTotalList.forEach(value -> {
                List<Trip> doList = tripRepository.findAllByDropOffId(Long.parseLong(value.get("id").toString()));
                Optional<Zone> zone = zoneRepository.findById(Long.parseLong(value.get("id").toString()));

                ZoneTotal zoneTotal = new ZoneTotal();
                zoneTotal.setPuTotal(Long.parseLong(value.get("pu_total").toString()));
                zoneTotal.setDoTotal(Long.valueOf(doList.size()));
                if (zone.isPresent()) {
                    zoneTotal.setZone(zone.get().getZone());
                }
                zoneTotalList.add(zoneTotal);
            });

            topZones.setZoneTotalList(zoneTotalList);

        } else if (order.equals("dropoffs")) {
            List<ZoneTotal> zoneTotalList = new ArrayList<>();
            List<Map<String, Object>> repoTotalList = tripRepository.findBestDropoffs(PageRequest.of(0, 5));

            repoTotalList.forEach(value -> {
                List<Trip> doList = tripRepository.findAllByPickUpId(Long.parseLong(value.get("id").toString()));
                Optional<Zone> zone = zoneRepository.findById(Long.parseLong(value.get("id").toString()));

                ZoneTotal zoneTotal = new ZoneTotal();
                zoneTotal.setPuTotal(Long.valueOf(doList.size()));
                zoneTotal.setDoTotal(Long.parseLong(value.get("do_total").toString()));
                if (zone.isPresent()) {
                    zoneTotal.setZone(zone.get().getZone());
                }

                zoneTotalList.add(zoneTotal);
            });

            topZones.setZoneTotalList(zoneTotalList);


        } else {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Order parameter is invalid.", "Order parameter must be set to [pickups] or [dropoffs]");
        }


        return ResponseEntity.ok(topZones);
    }

    public ResponseEntity<SumZoneTrips> zoneTrips(Long zone, Instant date) {

        return null;
    }

    public ResponseEntity<Object> listYellow() {

        return null;
    }
}
