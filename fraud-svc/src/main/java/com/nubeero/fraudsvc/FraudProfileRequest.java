package com.nubeero.fraudsvc;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FraudProfileRequest {

    int brokerid;
    String brokerName;
    int brokerRiskProfile;
}
