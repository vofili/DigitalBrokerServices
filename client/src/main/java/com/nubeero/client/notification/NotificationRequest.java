package com.nubeero.client.notification;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {

    Integer toBrokerId;
    String toCustomerEmail;
    String message;

}
