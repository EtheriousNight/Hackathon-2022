package com.hackathon.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    private final EventService eventService;
    private final LocationService locationService;

    @Autowired
    public SearchService(EventService eventService, LocationService locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }

}
