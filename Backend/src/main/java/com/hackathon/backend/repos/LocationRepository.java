package com.hackathon.backend.repos;

import com.hackathon.backend.data.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query("SELECT l FROM Location l WHERE l.street = ?1")
    Optional<Location> findLocationByStreet(String street);

}
