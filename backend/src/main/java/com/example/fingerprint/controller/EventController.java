package com.example.fingerprint.controller;

import com.example.fingerprint.model.Event;
import com.example.fingerprint.repository.EventRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EventController {

    private final EventRepository repo;

    public EventController(EventRepository repo) {
        this.repo = repo;
    }

    // ✅ POST API
    @PostMapping("/track")
    public Event trackEvent(@RequestBody Event event) {
        event.setTimestamp(LocalDateTime.now());

        System.out.println("Received: " + event.getFingerprintId());

        return repo.save(event);
    }

    
    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return repo.findAll();
    }
}