package com.nubeero.client.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="notification-service")
public interface NotificationClient {

    @PostMapping("/api/v1/notification/send")
    public NotificationResponse sendNotification(@RequestBody NotificationRequest notificationRequest);

}
