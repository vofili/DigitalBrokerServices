package com.nubeero.brokersvc;


import com.nubeero.client.fraud.FraudCheckResponse;
import com.nubeero.client.notification.NotificationResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrokerRegisterResponse {

    Integer brokerId;
    String brokerName;
    String responseCode;
    String responseMesssage;

    NotificationResponse notificationResponse;
    FraudCheckResponse fraudCheckResponse;
}
