package org.example.tdm;


import lombok.*;
import org.example.dto.PatientDTO;
import org.example.entity.SuperEntity;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentTM implements SuperEntity {
    private String payId;
    private double amount;
    private LocalDate paymentDate;
    private String paymentMethod;
    private String status;
    private PatientDTO patient;

}
