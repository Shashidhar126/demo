package com.example.demo.service;

import com.example.demo.entity.GeoFenceAlert;
import com.example.demo.repository.GeoFenceAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeoFenceAlertService {
    @Autowired
    private GeoFenceAlertRepository repository;

    public GeoFenceAlert save(GeoFenceAlert geoFenceAlert) {
        return repository.save(geoFenceAlert);
    }

    public GeoFenceAlert getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}