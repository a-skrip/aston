package ru.aston.application.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import ru.aston.application.entity.Doctor;
import ru.aston.application.entity.Patient;

import java.util.List;

@Data
@NoArgsConstructor
public class DoctorDTO {

    private Doctor doctor;
    private List<Patient> patientList;
}
