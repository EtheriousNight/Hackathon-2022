package com.hackathon.backend.service;

import com.hackathon.backend.data.model.Event;
import com.hackathon.backend.error.EventNotFoundException;
import com.hackathon.backend.error.LocationNotFoundException;
import com.hackathon.backend.repos.EventRepository;
import com.hackathon.backend.repos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public EventService(EventRepository eventRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Transactional
    public Event createEvent(Event event, Long locationId) {
        var optionalLocation = locationRepository.findById(locationId);
        if (optionalLocation.isEmpty()) {
            throw new LocationNotFoundException("Location with the ID: " + locationId + " was not found.");
        } else {
            var location = optionalLocation.get();
            event.setLocation(location);
            return eventRepository.save(event);
        }
    }

    public Event getEventById(Long id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isEmpty()) {
            throw new EventNotFoundException("Event with the ID: " + id + " could not be found!");
        } else {
            return optionalEvent.get();
        }
    }

    public List<Event> getEventsByStreet(String street) {
        return eventRepository.findEventsByStreet(street);
    }

    public List<Event> getEventsByCityDistrict(String street) {
        var optionalLocation = locationRepository.findLocationByStreet(street);
        if (optionalLocation.isEmpty()) {
            throw new LocationNotFoundException("Location with street " + street + " could not be found");
        } else {
            var location = optionalLocation.get();
            var cityDistrict = location.getCityDistrict();
            return eventRepository.findEventsByCityDistrict(cityDistrict);
        }
    }

    public List<Event> getEventsByCity(String street) {
        var optionalLocation = locationRepository.findLocationByStreet(street);
        if (optionalLocation.isEmpty()) {
            throw new LocationNotFoundException("Location with street " + street + " could not be found");
        } else {
            var location = optionalLocation.get();
            var city = location.getCity();
            return eventRepository.findEventsByCity(city);
        }
    }

    public List<Event> getEventsByCounty(String street) {
        var optionalLocation = locationRepository.findLocationByStreet(street);
        if (optionalLocation.isEmpty()) {
            throw new LocationNotFoundException("Location with street " + street + " could not be found");
        } else {
            var location = optionalLocation.get();
            var county = location.getCity();
            return eventRepository.findEventsByCounty(county);
        }
    }

}
