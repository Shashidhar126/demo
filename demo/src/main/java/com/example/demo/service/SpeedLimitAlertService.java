package com.example.demo.service;

import com.example.demo.entity.SpeedLimitAlert;
import com.example.demo.repository.SpeedLimitAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpeedLimitAlertService {
    @Autowired
    private SpeedLimitAlertRepository repository;

    public SpeedLimitAlert save(SpeedLimitAlert speedLimitAlert) {
        return repository.save(speedLimitAlert);
    }

    public SpeedLimitAlert getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
