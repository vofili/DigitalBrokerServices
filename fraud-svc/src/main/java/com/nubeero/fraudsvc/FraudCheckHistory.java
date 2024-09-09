package com.nubeero.fraudsvc;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FraudCheckHistory {

    @Id
    @SequenceGenerator(name="fraud_check_history_sequence",
            sequenceName="fraud_check_history_sequence")
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="fraud_check_history_sequence")
    private Integer id;
    private Integer brokerId;
    private boolean fraudExists;
    private LocalDateTime createdAt;




}
