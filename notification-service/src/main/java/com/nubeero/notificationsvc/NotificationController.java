package com.nubeero.notificationsvc;


import com.nubeero.client.notification.NotificationRequest;
import com.nubeero.client.notification.NotificationResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notification")
@AllArgsConstructor
public class NotificationController {


    private final NotificationService notificationService;

    @PostMapping("send")
    public NotificationResponse sendNotification(@RequestBody NotificationRequest notificationRequest){
        NotificationResponse response = notificationService.sendNotification(notificationRequest);
        return response;
    }
}
