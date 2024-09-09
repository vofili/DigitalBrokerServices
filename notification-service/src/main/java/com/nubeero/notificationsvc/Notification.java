package com.nubeero.notificationsvc;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Notification {

    @Id
    @SequenceGenerator(name="notification_sequence",
                    sequenceName="notification_sequence")
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
                    generator="notification_sequence")
    Integer notificationId;

    Integer toCustomerId;
    String toCustomerEmail;
    String sender;
    String message;
    LocalDateTime createdAt;

}
