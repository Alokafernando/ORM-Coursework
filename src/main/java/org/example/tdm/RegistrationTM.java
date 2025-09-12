package org.example.tdm;


import lombok.*;
import org.example.entity.Patient;
import org.example.entity.RegistrationId;
import org.example.entity.TherapyProgram;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegistrationTM {
    private RegistrationId id = new RegistrationId();
    private Patient patient;
    private TherapyProgram therapyProgram;
    private double downPayment;
}
