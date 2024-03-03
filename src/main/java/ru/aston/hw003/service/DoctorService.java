package ru.aston.hw003.service;

import ru.aston.hw003.entity.Doctor;
import ru.aston.hw003.dao.DoctorDAO;

public class DoctorService {

    DoctorDAO doctorDAO = new DoctorDAO();

    public Doctor getDoctorById(long id) {

        return doctorDAO.getDoctorById(id);

    }

    public void createDoctor(Doctor doctor) {

        doctorDAO.addDoctor(doctor);
    }
}

