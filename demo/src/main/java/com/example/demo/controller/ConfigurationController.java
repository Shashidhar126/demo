package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.payload.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/configuration")
public class ConfigurationController {

    @Autowired
    private ConfigurationDataService configurationDataService;
    @Autowired
    private CommunityNotificationService communityNotificationService;

    @Autowired
    private GeneralNotificationService generalNotificationService;

    @Autowired
    private VehicleNotificationService vehicleNotificationService;

    @Autowired
    private SpeedLimitAlertService speedLimitAlertService;

    @Autowired
    private GeoFenceAlertService geoFenceAlertService;



    @PostMapping("/save")
    public ResponseEntity<String> saveConfiguration(@RequestBody ConfigurationData configurationData) {
        try {

            if (configurationData.getId() != null) {
                return new ResponseEntity<>("ID should not be set manually", HttpStatus.BAD_REQUEST);
            }

            configurationDataService.saveConfigurationData(configurationData);
            return new ResponseEntity<>("Configuration saved successfully", HttpStatus.OK);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Database Access Error", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @GetMapping("/get/{id}")
    public ResponseEntity<ConfigurationDataDTO> getConfiguration(@PathVariable Long id) {
        try {
            // Retrieve ConfigurationData entity from the service
            ConfigurationData configurationData = configurationDataService.findConfigurationDataWithDetails(id);

            // Convert entity to DTO
            ConfigurationDataDTO configurationDataDTO = convertToDTO(configurationData);

            return new ResponseEntity<>(configurationDataDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ConfigurationDataDTO>> getAllConfigurations() {
        try {
            // Retrieve list of ConfigurationData entities from the service
            List<ConfigurationData> configurationDataList = configurationDataService.findAllConfigurationData();

            // Convert entities to DTOs
            List<ConfigurationDataDTO> configurationDataDTOList = configurationDataList.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());

            return new ResponseEntity<>(configurationDataDTOList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Helper method to convert DTO to entity
    private ConfigurationData convertToEntity(ConfigurationDataDTO configurationDataDTO) {
        ConfigurationData configurationData = new ConfigurationData();

        configurationData.setIsEnabled(configurationDataDTO.getIsEnabled());
        configurationData.setVehicleNotification(convertToEntity(configurationDataDTO.getVehicleNotification()));
        configurationData.setGeneralNotification(convertToEntity(configurationDataDTO.getGeneralNotification()));
        configurationData.setCommunityNotification(convertToEntity(configurationDataDTO.getCommunityNotification()));
        return configurationData;
    }

    private VehicleNotification convertToEntity(VehicleNotificationDTO vehicleNotificationDTO) {
        VehicleNotification vehicleNotification = new VehicleNotification();
        vehicleNotification.setIsEnabled(vehicleNotificationDTO.getIsEnabled());
        vehicleNotification.setIsTowAlertEnabled(vehicleNotificationDTO.getIsTowAlertEnabled());
        vehicleNotification.setIsLowRangeAlertEnabled(vehicleNotificationDTO.getIsLowRangeAlertEnabled());
        vehicleNotification.setIsLowBatteryAlertEnabled(vehicleNotificationDTO.getIsLowBatteryAlertEnabled());
        vehicleNotification.setIsBatteryHealthAlertEnabled(vehicleNotificationDTO.getIsBatteryHealthAlertEnabled());
        vehicleNotification.setIsFallDetectionAlertEnabled(vehicleNotificationDTO.getIsFallDetectionAlertEnabled());
        vehicleNotification.setSpeedLimitAlert(convertToEntity(vehicleNotificationDTO.getSpeedLimitAlert()));
        vehicleNotification.setGeoFenceAlert(convertToEntity(vehicleNotificationDTO.getGeoFenceAlert()));
        return vehicleNotification;
    }

    private GeneralNotification convertToEntity(GeneralNotificationDTO generalNotificationDTO) {
        GeneralNotification generalNotification = new GeneralNotification();
        generalNotification.setEnabled(generalNotificationDTO.getEnabled());
        generalNotification.setAppUpdateEnabled(generalNotificationDTO.getAppUpdateEnabled());
        generalNotification.setAppRatingEnabled(generalNotificationDTO.getAppRatingEnabled());
        generalNotification.setBugReportResolutionOrUpdatesEnabled(generalNotificationDTO.getBugReportResolutionOrUpdatesEnabled());
        generalNotification.setBookingOrDeliveryStatusEnabled(generalNotificationDTO.getBookingOrDeliveryStatusEnabled());
        generalNotification.setExperienceCentreBookingEnabled(generalNotificationDTO.getExperienceCentreBookingEnabled());
        generalNotification.setTestRideBookingEnabled(generalNotificationDTO.getTestRideBookingEnabled());
        generalNotification.setLatestOffersEnabled(generalNotificationDTO.getLatestOffersEnabled());
        generalNotification.setStoreUpdatesEnabled(generalNotificationDTO.getStoreUpdatesEnabled());
        return generalNotification;
    }

    private CommunityNotification convertToEntity(CommunityNotificationDTO communityNotificationDTO) {
        CommunityNotification communityNotification = new CommunityNotification();
        communityNotification.setIsEnabled(communityNotificationDTO.getIsEnabled());
        communityNotification.setIsLikeOrReactionOnPhotosEnabled(communityNotificationDTO.getIsLikeOrReactionOnPhotosEnabled());
        communityNotification.setIsCommentOnPostsEnabled(communityNotificationDTO.getIsCommentOnPostsEnabled());
        communityNotification.setIsSharingOnPostsEnabled(communityNotificationDTO.getIsSharingOnPostsEnabled());
        communityNotification.setIsTaggingEnabled(communityNotificationDTO.getIsTaggingEnabled());
        communityNotification.setIsCoinsAndBadgesEnabled(communityNotificationDTO.getIsCoinsAndBadgesEnabled());
        communityNotification.setIsEventsOrRidesEnabled(communityNotificationDTO.getIsEventsOrRidesEnabled());
        communityNotification.setIsRoleChangesEnabled(communityNotificationDTO.getIsRoleChangesEnabled());
        communityNotification.setIsCommunityUpdatesEnabled(communityNotificationDTO.getIsCommunityUpdatesEnabled());
        return communityNotification;
    }

    private SpeedLimitAlert convertToEntity(SpeedLimitAlertDTO speedLimitAlertDTO) {
        SpeedLimitAlert speedLimitAlert = new SpeedLimitAlert();
        speedLimitAlert.setIsEnabled(speedLimitAlertDTO.getIsEnabled());
        speedLimitAlert.setSpeedLimit(speedLimitAlertDTO.getSpeedLimit());
        speedLimitAlert.setNotificationIntervalInMinute(speedLimitAlertDTO.getNotificationIntervalInMinute());
        return speedLimitAlert;
    }

    private GeoFenceAlert convertToEntity(GeoFenceAlertDTO geoFenceAlertDTO) {
        GeoFenceAlert geoFenceAlert = new GeoFenceAlert();
        geoFenceAlert.setIsEnabled(geoFenceAlertDTO.getIsEnabled());
        geoFenceAlert.setNotificationIntervalInMinute(geoFenceAlertDTO.getNotificationIntervalInMinute());
        return geoFenceAlert;
    }

    // Helper method to convert entity to DTO
    private ConfigurationDataDTO convertToDTO(ConfigurationData configurationData) {
        ConfigurationDataDTO configurationDataDTO = new ConfigurationDataDTO();
configurationDataDTO.setId(configurationData.getId());
        configurationDataDTO.setIsEnabled(configurationData.getIsEnabled());
        configurationDataDTO.setVehicleNotification(convertToDTO(configurationData.getVehicleNotification()));
        configurationDataDTO.setGeneralNotification(convertToDTO(configurationData.getGeneralNotification()));
        configurationDataDTO.setCommunityNotification(convertToDTO(configurationData.getCommunityNotification()));
        return configurationDataDTO;
    }

    private VehicleNotificationDTO convertToDTO(VehicleNotification vehicleNotification) {
        VehicleNotificationDTO vehicleNotificationDTO = new VehicleNotificationDTO();
        vehicleNotificationDTO.setIsEnabled(vehicleNotification.getIsEnabled());
        vehicleNotificationDTO.setIsTowAlertEnabled(vehicleNotification.getIsTowAlertEnabled());
        vehicleNotificationDTO.setIsLowRangeAlertEnabled(vehicleNotification.getIsLowRangeAlertEnabled());
        vehicleNotificationDTO.setIsLowBatteryAlertEnabled(vehicleNotification.getIsLowBatteryAlertEnabled());
        vehicleNotificationDTO.setIsBatteryHealthAlertEnabled(vehicleNotification.getIsBatteryHealthAlertEnabled());
        vehicleNotificationDTO.setIsFallDetectionAlertEnabled(vehicleNotification.getIsFallDetectionAlertEnabled());
        vehicleNotificationDTO.setSpeedLimitAlert(convertToDTO(vehicleNotification.getSpeedLimitAlert()));
        vehicleNotificationDTO.setGeoFenceAlert(convertToDTO(vehicleNotification.getGeoFenceAlert()));
        return vehicleNotificationDTO;
    }

    private GeneralNotificationDTO convertToDTO(GeneralNotification generalNotification) {
        GeneralNotificationDTO generalNotificationDTO = new GeneralNotificationDTO();
        generalNotificationDTO.setEnabled(generalNotification.getEnabled());
        generalNotificationDTO.setAppUpdateEnabled(generalNotification.getAppUpdateEnabled());
        generalNotificationDTO.setAppRatingEnabled(generalNotification.getAppRatingEnabled());
        generalNotificationDTO.setBugReportResolutionOrUpdatesEnabled(generalNotification.getBugReportResolutionOrUpdatesEnabled());
        generalNotificationDTO.setBookingOrDeliveryStatusEnabled(generalNotification.getBookingOrDeliveryStatusEnabled());
        generalNotificationDTO.setExperienceCentreBookingEnabled(generalNotification.getExperienceCentreBookingEnabled());
        generalNotificationDTO.setTestRideBookingEnabled(generalNotification.getTestRideBookingEnabled());
        generalNotificationDTO.setLatestOffersEnabled(generalNotification.getLatestOffersEnabled());
        generalNotificationDTO.setStoreUpdatesEnabled(generalNotification.getStoreUpdatesEnabled());
        return generalNotificationDTO;
    }

    private CommunityNotificationDTO convertToDTO(CommunityNotification communityNotification) {
        CommunityNotificationDTO communityNotificationDTO = new CommunityNotificationDTO();
        communityNotificationDTO.setIsEnabled(communityNotification.getIsEnabled());
        communityNotificationDTO.setIsLikeOrReactionOnPhotosEnabled(communityNotification.getIsLikeOrReactionOnPhotosEnabled());
        communityNotificationDTO.setIsCommentOnPostsEnabled(communityNotification.getIsCommentOnPostsEnabled());
        communityNotificationDTO.setIsSharingOnPostsEnabled(communityNotification.getIsSharingOnPostsEnabled());
        communityNotificationDTO.setIsTaggingEnabled(communityNotification.getIsTaggingEnabled());
        communityNotificationDTO.setIsCoinsAndBadgesEnabled(communityNotification.getIsCoinsAndBadgesEnabled());
        communityNotificationDTO.setIsEventsOrRidesEnabled(communityNotification.getIsEventsOrRidesEnabled());
        communityNotificationDTO.setIsRoleChangesEnabled(communityNotification.getIsRoleChangesEnabled());
        communityNotificationDTO.setIsCommunityUpdatesEnabled(communityNotification.getIsCommunityUpdatesEnabled());
        return communityNotificationDTO;
    }

    private SpeedLimitAlertDTO convertToDTO(SpeedLimitAlert speedLimitAlert) {
        SpeedLimitAlertDTO speedLimitAlertDTO = new SpeedLimitAlertDTO();
        speedLimitAlertDTO.setIsEnabled(speedLimitAlert.getIsEnabled());
        speedLimitAlertDTO.setSpeedLimit(speedLimitAlert.getSpeedLimit());
        speedLimitAlertDTO.setNotificationIntervalInMinute(speedLimitAlert.getNotificationIntervalInMinute());
        return speedLimitAlertDTO;
    }

    private GeoFenceAlertDTO convertToDTO(GeoFenceAlert geoFenceAlert) {
        GeoFenceAlertDTO geoFenceAlertDTO = new GeoFenceAlertDTO();
        geoFenceAlertDTO.setIsEnabled(geoFenceAlert.getIsEnabled());
        geoFenceAlertDTO.setNotificationIntervalInMinute(geoFenceAlert.getNotificationIntervalInMinute());
        return geoFenceAlertDTO;
    }
}
