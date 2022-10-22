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

    @GetMapping("/get/district/{cityDistrict}")
    public List<Event> getEventsByCityDistrict(@PathVariable String cityDistrict) {
        return eventService.getEventsByCityDistrict(cityDistrict);
    }

    @GetMapping("/get/city/{city}")
    public List<Event> getEventsByCity(@PathVariable String city) {
        return eventService.getEventsByCity(city);
    }

    @GetMapping("/get/county/{county}")
    public List<Event> getEventsByCounty(@PathVariable String county) {
        return eventService.getEventsByCounty(county);
    }

}
