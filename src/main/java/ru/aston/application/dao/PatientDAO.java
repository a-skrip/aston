package ru.aston.application.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.aston.application.entity.Patient;


@Repository
public class PatientDAO {


   private final SessionFactory sessionFactory;

    public PatientDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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