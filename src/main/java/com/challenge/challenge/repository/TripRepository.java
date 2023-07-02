package com.challenge.challenge.repository;

import com.challenge.challenge.domain.Trip;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    @Query(value = "SELECT z.id, COUNT(t.id) AS pu_total FROM trip t LEFT JOIN zone z ON z.id = t.\"pick_up_id\" GROUP BY t.\"pick_up_id\", z.id ORDER BY pu_total DESC", nativeQuery = true)
    List<Map<String, Object>> findBestPickups(Pageable pageable);

    @Query(value = "SELECT z.id, COUNT(t.id) AS do_total FROM trip t LEFT JOIN zone z ON z.id = t.\"drop_off_id\" GROUP BY t.\"drop_off_id\", z.id ORDER BY do_total DESC", nativeQuery = true)
    List<Map<String, Object>> findBestDropoffs(Pageable pageable);

    List<Trip> findAllByPickUpId(Long id);
    List<Trip> findAllByDropOffId(Long id);
}
