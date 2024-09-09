package com.nubeero.brokersvc;


import com.fasterxml.jackson.annotation.JsonProperty;

public record BrokerRegisterRequest(@JsonProperty("rcnumber")String rcNumber,
                                    @JsonProperty("brokername") String brokerName,
                                    @JsonProperty("brokerrbno")String brokerRbno,
                                    @JsonProperty("city")String city,
                                    @JsonProperty("street") String street,
                                    @JsonProperty("state") String state,
                                    @JsonProperty("postcode") String postCode) {





}
