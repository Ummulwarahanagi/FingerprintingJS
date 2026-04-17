package com.example.fingerprint.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fingerprintId;
    private String event;
    private String url;
    private LocalDateTime timestamp;

    // Getter for id
    public Long getId() {
        return id;
    }

    // Getter & Setter for fingerprintId
    public String getFingerprintId() {
        return fingerprintId;
    }

    public void setFingerprintId(String fingerprintId) {
        this.fingerprintId = fingerprintId;
    }

    // Getter & Setter for event
    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    // Getter & Setter for url
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // Getter & Setter for timestamp
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}