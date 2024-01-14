package com.example.demo.repository;

import com.example.demo.entity.GeoFenceAlert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeoFenceAlertRepository extends JpaRepository<GeoFenceAlert, Long> {
    // Add custom queries if needed
}
