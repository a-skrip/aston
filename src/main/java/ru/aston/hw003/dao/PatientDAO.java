package ru.aston.hw003.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import ru.aston.hw003.entity.Doctor;
import ru.aston.hw003.entity.Patient;
import ru.aston.hw003.utils.HibernateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Patient getPatientById(long id) {

        try (Session session = sessionFactory.getCurrentSession()) {

            Transaction transaction = session.beginTransaction();

            Patient patient = session.get(Patient.class, id);
            transaction.commit();

            return patient;
        }
    }

    public void addPatient(Patient patient) {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(patient);
            session.getTransaction().commit();
            session.close();
        }
    }
}