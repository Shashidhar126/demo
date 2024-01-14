package com.example.demo.payload;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurationDataDTO {
    private Long id;
    private Boolean isEnabled;
    private VehicleNotificationDTO vehicleNotification;
    private GeneralNotificationDTO generalNotification;
    private CommunityNotificationDTO communityNotification;
}
