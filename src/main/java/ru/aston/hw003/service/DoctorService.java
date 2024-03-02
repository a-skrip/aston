package ru.aston.hw003.service;

import ru.aston.hw003.entity.Doctor;
import ru.aston.hw003.dao.DoctorDAO;
import ru.aston.hw003.dao.PatientDAO;

import java.util.List;

public class DoctorService {


    DoctorDAO doctorDAO = new DoctorDAO();
    PatientDAO patientDAO = new PatientDAO();

//    public DoctorDTO getDoctorWithPatient(Long id) {
//
//        Doctor doctor = doctorDAO.getDoctorById(id);
//        List<Patient> patientListByDoctorId = patientDAO.getPatientListByDoctorId(doctor.getId());
//        DoctorDTO doctorDTO = new DoctorDTO(doctor,patientListByDoctorId);
//        return doctorDTO;
//    }
//
//    public Doctor getDoctor(Long id) {
//
//        return doctorDAO.getDoctorById(id);
//    }


    public List<Doctor> getListDoctor() {
        return doctorDAO.getListDoctors();

    }
}

//    public void createDoctor(Doctor doctor) {
//        doctorDAO.addDoctor(doctor.getName(), doctor.getSpecialization(), doctor.getPhoneNumber());
//    }
//
//
//    public Patient getPatient(Long id) {
//
//        return patientDAO.getPatientById(id);
//    }
//
//    public List<Patient> getListPatient() {
//        return patientDAO.getListPatient();
//    }
//
//
//}
