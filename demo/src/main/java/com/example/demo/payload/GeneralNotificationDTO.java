package com.example.demo.payload;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralNotificationDTO {

    private Boolean enabled;
    private Boolean appUpdateEnabled;
    private Boolean appRatingEnabled;
    private Boolean bugReportResolutionOrUpdatesEnabled;
    private Boolean bookingOrDeliveryStatusEnabled;
    private Boolean experienceCentreBookingEnabled;
    private Boolean testRideBookingEnabled;
    private Boolean latestOffersEnabled;
    private Boolean storeUpdatesEnabled;

}