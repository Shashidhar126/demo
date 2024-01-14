package com.example.demo.service;

import com.example.demo.entity.CommunityNotification;
import com.example.demo.repository.CommunityNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityNotificationService {
    @Autowired
    private CommunityNotificationRepository repository;

    public CommunityNotification save(CommunityNotification communityNotification) {
        return repository.save(communityNotification);
    }

    public CommunityNotification getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}

