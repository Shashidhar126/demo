package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enabled;
    private String appUpdateEnabled;
    private String appRatingEnabled;
    private String bugReportResolutionOrUpdatesEnabled;
    private String bookingOrDeliveryStatusEnabled;
    private String experienceCentreBookingEnabled;
    private String testRideBookingEnabled;
    private String latestOffersEnabled;
    private String storeUpdatesEnabled;

    // Constructors, getters, setters
}
