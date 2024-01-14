package com.example.demo.payload;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleNotificationDTO {

    private Boolean isEnabled;
    private Boolean isTowAlertEnabled;
    private Boolean isLowRangeAlertEnabled;
    private Boolean isLowBatteryAlertEnabled;
    private Boolean isBatteryHealthAlertEnabled;
    private Boolean isFallDetectionAlertEnabled;
    private SpeedLimitAlertDTO speedLimitAlert;
    private GeoFenceAlertDTO geoFenceAlert;
}
