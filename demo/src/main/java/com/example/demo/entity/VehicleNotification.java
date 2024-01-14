package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isEnabled;
    private Boolean isTowAlertEnabled;
    private Boolean isLowRangeAlertEnabled;
    private Boolean isLowBatteryAlertEnabled;
    private Boolean isBatteryHealthAlertEnabled;
    private Boolean isFallDetectionAlertEnabled;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "speed_limit_alert_id")
    private SpeedLimitAlert speedLimitAlert;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "geo_fence_alert_id")
    private GeoFenceAlert geoFenceAlert;

    // Constructors, getters, setters
}


