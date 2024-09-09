package com.nubeero.notificationsvc;

import com.nubeero.client.notification.NotificationRequest;
import com.nubeero.client.notification.NotificationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;


@AllArgsConstructor
@Service
public class NotificationService {

    NotificationRepository notificationRepo;


    public NotificationResponse sendNotification(NotificationRequest notificationRequest){
        Notification notification = Notification.builder()
                .message(notificationRequest.getMessage())
                .sender("")
                .createdAt(LocalDateTime.now())
                .toCustomerEmail(notificationRequest.getToCustomerEmail())
                .toCustomerId(notificationRequest.getToBrokerId())
                .build();
                notificationRepo.saveAndFlush(notification);

        return new NotificationResponse(notification.getNotificationId()
        ,"success","successfully sent notification","00");
    }
}
