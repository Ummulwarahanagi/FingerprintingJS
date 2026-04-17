package com.example.fingerprint.repository;

import com.example.fingerprint.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}