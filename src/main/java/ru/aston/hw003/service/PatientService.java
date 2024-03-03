package ru.aston.hw003.service;

import ru.aston.hw003.dao.DoctorDAO;
import ru.aston.hw003.dao.PatientDAO;
import ru.aston.hw003.dto.DoctorDTO;
import ru.aston.hw003.entity.Doctor;
import ru.aston.hw003.entity.Patient;

public class PatientService {

    PatientDAO patientDAO = new PatientDAO();

    public Patient getPatientById(long id) {

        return patientDAO.getPatientById(id);
    }

    public void createPatient(Patient patient) {

        patientDAO.addPatient(patient);
    }
}