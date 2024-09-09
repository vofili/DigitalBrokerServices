package com.nubeero.brokersvc;

import com.nubeero.client.fraud.FraudCheckResponse;
import com.nubeero.client.fraud.FraudClient;
import com.nubeero.client.notification.NotificationClient;
import com.nubeero.client.notification.NotificationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.nubeero.client.notification.NotificationRequest;

@Slf4j
@Service
public record BrokerService(BrokerRepository brokerRepository,
                            RestTemplate restTemplate,
                            FraudClient fraudClient,
                            NotificationClient notificationClient) {

    public BrokerRegisterResponse registerBroker(BrokerRegisterRequest brokerRegisterRequest){

        Broker broker = Broker.builder().brokerName(brokerRegisterRequest.brokerName())
                .brokerRbno(brokerRegisterRequest.brokerRbno())
                .rcNumber(brokerRegisterRequest.rcNumber())
                .street(brokerRegisterRequest.street())
                .city(brokerRegisterRequest.city())
                .state(brokerRegisterRequest.state())
                .postCode(brokerRegisterRequest.postCode())
                .build();
        //:- validate the fields
        //:-check for duplicate brokerRcNumber
        log.info("Broker to save {}",broker.toString());
        brokerRepository.saveAndFlush(broker);
        //:-store in Db
        //:- check fraud service
//        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://FRAUD-SERVICE/api/v1/fraud-check/{brokerId}",
//        FraudCheckResponse.class, broker.getId());
        FraudCheckResponse fraudResponse = fraudClient.doFraudCheck(broker.getId());
        if(fraudResponse.isFraudStatus()){
            throw new IllegalStateException("Fraud exception");
        }
        //:- send notification


        String notificationMessage = broker.getBrokerName()+" has been successfully created";
        NotificationResponse notifResp = notificationClient.sendNotification( new NotificationRequest(broker.getId()
        ,broker.getBrokerEmail(),notificationMessage));

        return new BrokerRegisterResponse(broker.getId(),broker.getBrokerName(),"00","successful",notifResp,fraudResponse);

    }



}
