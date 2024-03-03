package ru.aston.hw003.service;

import ru.aston.hw003.dto.DoctorDTO;
import ru.aston.hw003.dto.DoctorWithPatientDTO;
import ru.aston.hw003.dto.PatientDTO;
import ru.aston.hw003.entity.Doctor;
import ru.aston.hw003.dao.DoctorDAO;
import ru.aston.hw003.entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class DoctorService {

    DoctorDAO doctorDAO = new DoctorDAO();

    public DoctorWithPatientDTO getDoctorById(long id) {

        Doctor doctorById = doctorDAO.getDoctorById(id);
        final List<PatientDTO> patientDTOList = new ArrayList<>();
        List<Patient> patient = doctorById.getPatient();

        for (Patient elem : patient) {
            PatientDTO patientDTO = new PatientDTO(elem.getName());
            patientDTOList.add(patientDTO);
        }



        return new DoctorWithPatientDTO(
                doctorById.getName(), doctorById.getPhoneNumber(), doctorById.getSpecialization(), patientDTOList);

    }

    public void createDoctor(Doctor doctor) {

        doctorDAO.addDoctor(doctor);
    }
}

