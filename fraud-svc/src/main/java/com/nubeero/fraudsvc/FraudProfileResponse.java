package com.nubeero.fraudsvc;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FraudProfileResponse {
    String responseCode;
    String responseMessage;
    int fraudRiskProfile;
}
