package com.nubeero.fraudsvc;


import com.nubeero.client.fraud.FraudCheckResponse;
import jakarta.ws.rs.PUT;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/fraud-check/")
@RestController
@AllArgsConstructor
public class FraudCheckController {


    private final FraudCheckService fraudCheckService;

    @GetMapping("{brokerId}")
    public FraudCheckResponse doFraudCheck(@PathVariable("brokerId") Integer brokerId){
           Boolean fraudCheckResult = fraudCheckService.isFraudBroker(brokerId);
           return new FraudCheckResponse(brokerId,fraudCheckResult);
    }

    @GetMapping("/riskscore")
    public Integer calcCheckSum(@RequestParam("custcode") int custcode,@RequestParam("position") int pos ){
            return fraudCheckService.calcCustomerRiskScore(custcode);
    }

    @GetMapping("/broker/{id}/{rcno}")
    public FraudCheckResponse calcBrokerFraudScore(@PathVariable("id") int brokerId,@PathVariable("rcno") String rcno){
        return new FraudCheckResponse(brokerId, false);
    }

    @PutMapping("/fraudprofile/{id}")
    public ResponseEntity<FraudProfileResponse> doFraudProfileUpdate(@RequestBody FraudProfileRequest fraudProfileRequest, @PathVariable("id") int id){
        FraudProfileResponse fr=new FraudProfileResponse();
        return ResponseEntity.ok(fr);
    }
}
