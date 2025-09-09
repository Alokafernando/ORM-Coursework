package org.example.dto;

import com.gdse.serenity.entity.SuperEntity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TherapySessionDTO implements SuperEntity {
    private String tsId;
    private LocalDate sessionDate;
    private TherapistDTO therapist;
    private PatientDTO patient;
    private TherapyProgramDTO program;

    public TherapySessionDTO(String tsId, LocalDate sessionDate) {
        this.tsId = tsId;
        this.sessionDate = sessionDate;
    }

    public TherapySessionDTO(String id, LocalDate date, String therapistId, String patientId, String programId) {
        this.tsId = id;
        this.sessionDate = date;
    }
}
