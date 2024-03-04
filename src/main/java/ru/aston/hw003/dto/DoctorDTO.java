package ru.aston.hw003.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import ru.aston.hw003.entity.Doctor;
import ru.aston.hw003.entity.Patient;

import java.util.List;

@Data
@NoArgsConstructor
public class DoctorDTO {

    private Doctor doctor;
    private List<Patient> patientList;
}
