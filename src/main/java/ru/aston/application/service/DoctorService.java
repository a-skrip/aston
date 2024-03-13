package ru.aston.application.service;


import org.springframework.stereotype.Service;
import ru.aston.application.dto.DoctorWithPatientDTO;
import ru.aston.application.dto.PatientDTO;
import ru.aston.application.entity.Doctor;
import ru.aston.application.dao.DoctorDAO;
import ru.aston.application.entity.Patient;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {


    private final DoctorDAO doctorDAO;

    public DoctorService(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }


    public DoctorWithPatientDTO getDoctorById(long id) {

        Doctor doctorById = doctorDAO.getDoctorById(id);
        final List<PatientDTO> patientDTOList = new ArrayList<>();
        List<Patient> patient = doctorById.getPatient();

        for (Patient elem : patient) {
            PatientDTO patientDTO = new PatientDTO(elem.getName());
            patientDTOList.add(patientDTO);
        }

        return new DoctorWithPatientDTO(
                doctorById.getName(),
                doctorById.getPhoneNumber(),
                doctorById.getSpecialization(),
                patientDTOList);

    }

    public void createDoctor(Doctor doctor) {

        doctorDAO.addDoctor(doctor);
    }
}

