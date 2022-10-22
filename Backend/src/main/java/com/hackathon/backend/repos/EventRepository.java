package com.hackathon.backend.repos;

import com.hackathon.backend.data.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE e.location.street = ?1")
    List<Event> findEventsByStreet(String street);

    @Query("SELECT e FROM Event e WHERE e.location.cityDistrict = ?1")
    List<Event> findEventsByCityDistrict(String cityDistrict);

    @Query("SELECT e FROM Event e WHERE e.location.city = ?1")
    List<Event> findEventsByCity(String city);

    @Query("SELECT e FROM Event e WHERE e.location.county = ?1")
    List<Event> findEventsByCounty(String county);

}
