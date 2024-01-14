package com.example.demo.service;

//import com.example.demo.entity.ConfigurationData;
//import com.example.demo.repository.ConfigurationDataRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ConfigurationDataService {
//    @Autowired
//    private ConfigurationDataRepository repository;
//
//    public ConfigurationData save(ConfigurationData configurationData) {
//        return repository.save(configurationData);
//    }
//
//    public ConfigurationData getById(Long id) {
//        return repository.findById(id).orElse(null);
//    }
//}
//
import com.example.demo.entity.ConfigurationData;
import com.example.demo.repository.ConfigurationDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationDataService {

    @Autowired
    private ConfigurationDataRepository repository;

    public ConfigurationData save(ConfigurationData configurationData) {
        return repository.save(configurationData);
    }

    public ConfigurationData findConfigurationDataWithDetails(Long id) {
        return repository.findConfigurationDataWithDetails(id);
    }

    public List<ConfigurationData> getAllConfigurations() {
        return repository.findAll();
    }


    public List<ConfigurationData> findAllConfigurationData() {
        return repository.findAllConfigurationData();
    }
}