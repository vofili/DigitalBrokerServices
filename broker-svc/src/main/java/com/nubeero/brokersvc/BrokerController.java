package com.nubeero.brokersvc;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/v1/brokers/")
@RestController
public record BrokerController(BrokerService brokerService) {

    @PostMapping("/register")
    public BrokerRegisterResponse registerBroker(@RequestBody BrokerRegisterRequest brokerRegisterRequest){
        log.info("new Broker registration request {}",brokerRegisterRequest.toString());
        return brokerService.registerBroker(brokerRegisterRequest);

    }
}
