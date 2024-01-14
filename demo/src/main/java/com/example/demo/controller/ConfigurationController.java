package com.example.demo.controller;

import com.example.demo.entity.ConfigurationData;
import com.example.demo.service.ConfigurationDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import com.example.demo.entity.ConfigurationData;
//import com.example.demo.service.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/configuration")
//public class ConfigurationController {
//    @Autowired
//    private CommunityNotificationService communityNotificationService;
//
//    @Autowired
//    private GeneralNotificationService generalNotificationService;
//
//    @Autowired
//    private VehicleNotificationService vehicleNotificationService;
//
//    @Autowired
//    private SpeedLimitAlertService speedLimitAlertService;
//
//    @Autowired
//    private GeoFenceAlertService geoFenceAlertService;
//
//    @Autowired
//    private ConfigurationDataService configurationDataService;
//
//    @PostMapping("/save")
//    public ResponseEntity<String> saveConfiguration(@RequestBody ConfigurationData configurationData) {
//        try {
//            communityNotificationService.save(configurationData.getCommunityNotification());
//            generalNotificationService.save(configurationData.getGeneralNotification());
//            vehicleNotificationService.save(configurationData.getVehicleNotification());
//            speedLimitAlertService.save(configurationData.getVehicleNotification().getSpeedLimitAlert());
//            geoFenceAlertService.save(configurationData.getVehicleNotification().getGeoFenceAlert());
//            configurationDataService.save(configurationData);
//
//            return new ResponseEntity<>("Configuration saved successfully", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<ConfigurationData> getConfiguration(@PathVariable Long id) {
//        try {
//            ConfigurationData configurationData = configurationDataService.getById(id);
//            return new ResponseEntity<>(configurationData, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}
@RestController
@RequestMapping("/api/configuration")
public class ConfigurationController {
    @Autowired
    private ConfigurationDataService configurationDataService;

    @PostMapping("/save")
    public ResponseEntity<String> saveConfiguration(@RequestBody ConfigurationData configurationData) {
        try {
            // Save the configuration data along with related entities
            configurationDataService.save(configurationData);

            return new ResponseEntity<>("Configuration saved successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ConfigurationData> getConfiguration(@PathVariable Long id) {
        try {
            ConfigurationData configurationData = configurationDataService.findConfigurationDataWithDetails(id);
            return new ResponseEntity<>(configurationData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ConfigurationData>> getAllConfigurations() {
        try {
            List<ConfigurationData> configurationDataList = configurationDataService.findAllConfigurationData();
            return new ResponseEntity<>(configurationDataList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
