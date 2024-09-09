package com.nubeero.brokersvc;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Broker {

    @Id
            @SequenceGenerator(name="broker_id_sequence",
                    sequenceName="broker_id_sequence")
            @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="broker_id_sequence")
    int id;


    String rcNumber;

    String brokerName;
    String brokerEmail;
    String brokerRbno;
    String city;
    String street;
    String state;


    String postCode;
}
