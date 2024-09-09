package com.nubeero.client.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationResponse {

    private Integer notificationId;
    private String responseStatus;
    private String responseMessage;
    private String responseCode;
}
