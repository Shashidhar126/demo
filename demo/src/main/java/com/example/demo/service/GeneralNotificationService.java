package com.example.demo.service;

import com.example.demo.entity.GeneralNotification;
import com.example.demo.repository.GeneralNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneralNotificationService {
    @Autowired
    private GeneralNotificationRepository repository;

    public GeneralNotification save(GeneralNotification generalNotification) {
        return repository.save(generalNotification);
    }

    public GeneralNotification getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
