package com.nubeero.fraudsvc;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor

public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckRepo;

    public boolean isFraudBroker(Integer brokerId){
       Boolean fraudResult =false;
        FraudCheckHistory fraudCheckHistory = FraudCheckHistory.builder().brokerId(brokerId)
                .fraudExists(fraudResult)
                .createdAt(LocalDateTime.now())
                .build();
        fraudCheckRepo.save(fraudCheckHistory);
        return fraudResult;
    }

    public Integer calcCustomerRiskScore(Integer customercode) {
        return customercode%7;
    }
}
