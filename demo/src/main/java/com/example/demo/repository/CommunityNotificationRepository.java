package com.example.demo.repository;


import com.example.demo.entity.CommunityNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityNotificationRepository extends JpaRepository<CommunityNotification, Long> {
}
