package org.example.tdm;


import lombok.*;
import org.example.dto.PaymentDTO;
import org.example.dto.TherapyProgramDTO;
import org.example.dto.TherapySessionDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientTM {

    private String pId;
    private String name;
    private String email;
    private String phone;
    private String medicalHistory;
    private LocalDate registrationDate;
    private String status;
    private Set<TherapyProgramDTO> therapyPrograms = new HashSet<>();
    private List<TherapySessionDTO> therapySessions = new ArrayList<>();
    private List<PaymentDTO> payments = new ArrayList<>();

    public PatientTM(String pId, String name, String email, String phone, LocalDate registrationDate, String medicalHistory, String status) {
        this.pId = pId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.registrationDate = registrationDate;
        this.medicalHistory = medicalHistory;
        this.status = status;
    }
}
