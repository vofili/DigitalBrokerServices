package com.nubeero.client.fraud;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="fraud-service")
public interface FraudClient {

    @GetMapping("api/v1/fraud-check/{brokerId}")
    public FraudCheckResponse doFraudCheck(@PathVariable("brokerId") Integer brokerId);
}
