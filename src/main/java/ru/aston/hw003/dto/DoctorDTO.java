package ru.aston.hw003.dto;

import ru.aston.hw003.entity.Doctor;
import ru.aston.hw003.entity.Patient;

import java.util.List;

public class DoctorDTO {

    private Doctor doctor;
    private List<Patient> patientList;

    public DoctorDTO(Doctor doctor, List<Patient> patientList) {
        this.doctor = doctor;
        this.patientList = patientList;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }
}
