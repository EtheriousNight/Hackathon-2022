package com.hackathon.backend.api;

import com.hackathon.backend.data.model.Event;
import com.hackathon.backend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/event")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/all ")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping("/create/{location}")
    public Event createEvent(@RequestBody Event event, @PathVariable Long location) {
        return eventService.createEvent(event, location);
    }

    @GetMapping("/get/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @GetMapping("/get/street/{street}")
    public List<Event> getEventsByStreet(@PathVariable String street) {
        return eventService.getEventsByStreet(street);
    }

    @GetMapping("/get/district/{street}")
    public List<Event> getEventsByCityDistrict(@PathVariable String street) {
        return eventService.getEventsByCityDistrict(street);
    }

    @GetMapping("/get/city/{street}")
    public List<Event> getEventsByCity(@PathVariable String street) {
        return eventService.getEventsByCity(street);
    }

    @GetMapping("/get/county/{street}")
    public List<Event> getEventsByCounty(@PathVariable String street) {
        return eventService.getEventsByCounty(street);
    }

}
