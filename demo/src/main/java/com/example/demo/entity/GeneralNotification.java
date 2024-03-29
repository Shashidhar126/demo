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

    private Boolean enabled;
    private Boolean appUpdateEnabled;
    private Boolean appRatingEnabled;
    private Boolean bugReportResolutionOrUpdatesEnabled;
    private Boolean bookingOrDeliveryStatusEnabled;
    private Boolean experienceCentreBookingEnabled;
    private Boolean testRideBookingEnabled;
    private Boolean latestOffersEnabled;
    private Boolean storeUpdatesEnabled;

    // Constructors, getters, setters
}
