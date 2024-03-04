package ru.aston.hw003.service;


import ru.aston.hw003.dao.PatientDAO;
import ru.aston.hw003.dto.PatientDTO;
import ru.aston.hw003.entity.Patient;

public class PatientService {

    PatientDAO patientDAO = new PatientDAO();

    public PatientDTO getPatientById(long id) {

        Patient patientById = patientDAO.getPatientById(id);
        String name = patientById.getName();


        return new PatientDTO(name);
    }

    public void createPatient(Patient patient) {

        patientDAO.addPatient(patient);
    }
}