package com.hackathon.backend.data.initial;

import com.hackathon.backend.data.model.Event;
import com.hackathon.backend.data.model.Location;
import com.hackathon.backend.repos.EventRepository;
import com.hackathon.backend.repos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private EventRepository eventRepository;

    private final String[][] LOCATION_EXAMPLE_DATA = {
            {"Schlesische Straße", "Königshufen", "Görlitz", "Landkreis Görlitz"},
            {"Scultetusstraße", "Königshufen", "Görlitz", "Landreis Görlitz"},
            {"Promenadenstraße", "Biesnitz", "Görlitz", "Landkreis Görlitz"},
            {"Friedrich-Engels-Straße", "Weinhübel", "Görlitz", "Landkreis Görlitz"},
            {"Hugo-Keller-Straße", "Historische Altstadt", "Görlitz", "Landkreis Görlitz"}
    };

    private final String[][] EVENT_EXAMPLE_DATA = {
            {"Schienenersatzverkehr", "17.10.2022", "30.10.2022", "0"},
            {"Baustelle", "06.2022", "12.2030", "4"},
            {"Zirkus Festival", "15.07.2023", "17.07.2023", "1"},
            {"Marathon Durchlauf", "01.11.2022 - 10:00 Uhr", "01.11.2022 - 13:00 Uhr", "3"},
            {"Historische Straßenbahn", "23.12.2022", "23.12.2022", "2"}
    };

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        for (String[] event_example_datum : EVENT_EXAMPLE_DATA) {
            createEvent(event_example_datum);
        }
    }

    @Transactional
    public Location createLocation(String[] location) {
        var newLocation = new Location(location[0], location[1], location[2], location[3]);
        return locationRepository.save(newLocation);
    }

    @Transactional
    public Event createEvent(String[] event) {
        var newEvent = new Event(event[0], event[1], event[2]);
        var locationId = Integer.parseInt(event[3]);
        newEvent.setLocation(createLocation(LOCATION_EXAMPLE_DATA[locationId]));
        return eventRepository.save(newEvent);
    }

}
