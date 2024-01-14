package com.example.demo.repository;

import com.example.demo.entity.GeneralNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneralNotificationRepository extends JpaRepository<GeneralNotification, Long> {
}