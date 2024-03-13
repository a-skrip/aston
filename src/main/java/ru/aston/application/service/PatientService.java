package ru.aston.application.service;


import org.springframework.stereotype.Service;
import ru.aston.application.dao.PatientDAO;
import ru.aston.application.dto.PatientDTO;
import ru.aston.application.entity.Patient;

@Service
public class PatientService {

    private final PatientDAO patientDAO;

    public PatientService(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    public PatientDTO getPatientById(long id) {

        Patient patientById = patientDAO.getPatientById(id);
        String name = patientById.getName();


        return new PatientDTO(name);
    }

    public void createPatient(Patient patient) {

        patientDAO.addPatient(patient);
    }
}