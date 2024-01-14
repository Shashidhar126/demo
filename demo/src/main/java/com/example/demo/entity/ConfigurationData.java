package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurationData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isEnabled;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_notification_id")
    private VehicleNotification vehicleNotification;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "general_notification_id")
    private GeneralNotification generalNotification;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "community_notification_id")
    private CommunityNotification communityNotification;

    // Constructors, getters, setters
}