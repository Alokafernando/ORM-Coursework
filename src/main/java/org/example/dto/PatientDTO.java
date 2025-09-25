package org.example.dto;

import lombok.*;

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
public class PatientDTO {

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

    public PatientDTO(String id, String name, String email, String phone, String mediHistory, LocalDate regDate, String status) {
        this.pId = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.medicalHistory = mediHistory;
        this.registrationDate = regDate;
        this.status = status;
    }

    public PatientDTO(String pId, String name, String email, String phone, String status) {
        this.pId = pId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }


}
