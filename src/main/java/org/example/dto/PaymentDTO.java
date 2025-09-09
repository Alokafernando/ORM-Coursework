package org.example.dto;

import com.gdse.serenity.entity.SuperEntity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentDTO implements SuperEntity {
    private String payId;
    private double amount;
    private LocalDate paymentDate;
    private String paymentMethod;
    private String status;
    private PatientDTO patient;

    public PaymentDTO(String payId, double amount, LocalDate paymentDate, String paymentMethod, String status) {
        this.payId = payId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }
}
