package com.hackathon.backend.service;

import com.hackathon.backend.data.model.Location;
import com.hackathon.backend.error.LocationNotFoundException;
import com.hackathon.backend.repos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Transactional
    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location getLocationById(Long id) {
        Optional<Location> optionalLocation = locationRepository.findById(id);
        if (optionalLocation.isEmpty()) {
            throw new LocationNotFoundException("Location with the ID: " + id + " was not found!");
        } else {
            return optionalLocation.get();
        }
    }

}
