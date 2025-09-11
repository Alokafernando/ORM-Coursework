package org.example.tdm;

import com.gdse.serenity.dto.PatientDTO;
import com.gdse.serenity.entity.SuperEntity;
import lombok.*;

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
