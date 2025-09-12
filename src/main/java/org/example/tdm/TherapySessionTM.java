package org.example.tdm;


import lombok.*;
import org.example.dto.PatientDTO;
import org.example.dto.TherapistDTO;
import org.example.dto.TherapyProgramDTO;
import org.example.entity.SuperEntity;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TherapySessionTM implements SuperEntity {
    private String tsId;
    private LocalDate sessionDate;
    private TherapistDTO therapist;
    private PatientDTO patient;
    private TherapyProgramDTO program;

}
