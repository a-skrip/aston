package ru.aston.hw003.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.List;

@Data
@AllArgsConstructor
public class DoctorWithPatientDTO {

    private String nameDoctor;
    private String phone_number;
    private String specialization;
    private List<PatientDTO> patientList;



}
