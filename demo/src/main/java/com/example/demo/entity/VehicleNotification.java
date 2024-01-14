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

    private String isEnabled;
    private String isTowAlertEnabled;
    private String isLowRangeAlertEnabled;
    private String isLowBatteryAlertEnabled;
    private String isBatteryHealthAlertEnabled;
    private String isFallDetectionAlertEnabled;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "speed_limit_alert_id")
    private SpeedLimitAlert speedLimitAlert;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "geo_fence_alert_id")
    private GeoFenceAlert geoFenceAlert;
}
// Constructors, getters, setters


