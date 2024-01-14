package com.example.demo.repository;

import com.example.demo.entity.SpeedLimitAlert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeedLimitAlertRepository extends JpaRepository<SpeedLimitAlert, Long> {
    // Add custom queries if needed
}

