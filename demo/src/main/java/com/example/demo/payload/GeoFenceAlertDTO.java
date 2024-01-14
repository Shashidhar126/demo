package com.example.demo.payload;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoFenceAlertDTO {

    private Boolean isEnabled;
    private Integer notificationIntervalInMinute;
}