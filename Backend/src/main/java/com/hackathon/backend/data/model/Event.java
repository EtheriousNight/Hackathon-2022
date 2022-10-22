package com.hackathon.backend.data.model;

import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "start")
    private String start;
    @Column(name = "ending")
    private String ending;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    public Event() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String eventName) {
        this.name = eventName;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnding() {
        return ending;
    }

    public void setEnding(String end) {
        this.ending = end;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
