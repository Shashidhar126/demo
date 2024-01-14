package com.example.demo.service;

import com.example.demo.entity.VehicleNotification;
import com.example.demo.repository.VehicleNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleNotificationService {
    @Autowired
    private VehicleNotificationRepository repository;

    public VehicleNotification save(VehicleNotification vehicleNotification) {
        return repository.save(vehicleNotification);
    }

    public VehicleNotification getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}

