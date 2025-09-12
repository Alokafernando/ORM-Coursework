package org.example.dto;


import lombok.*;
import org.example.entity.Patient;
import org.example.entity.RegistrationId;
import org.example.entity.TherapyProgram;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegistrationDTO {
    private RegistrationId id = new RegistrationId();
    private Patient patient;
    private TherapyProgram therapyProgram;
    private double downPayment;

    public RegistrationDTO(String patientId, String programId, double downPayment) {
        this.id = new RegistrationId(patientId, programId);
        this.downPayment = downPayment;
    }
}
