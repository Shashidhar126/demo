package com.example.demo.payload;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpeedLimitAlertDTO {

    private Boolean isEnabled;
    private Integer speedLimit;
    private Integer notificationIntervalInMinute;
}