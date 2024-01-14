package com.example.demo.repository;

import com.example.demo.entity.VehicleNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleNotificationRepository extends JpaRepository<VehicleNotification, Long> {
}
