package ru.aston.application.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.aston.application.entity.Doctor;



@Repository
public class DoctorDAO {


    private final SessionFactory sessionFactory;

    public DoctorDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void addDoctor(Doctor doctor) {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(doctor);
            session.getTransaction().commit();
            session.close();
        }
    }

    public Doctor getDoctorById(long id) {

        try (Session session = sessionFactory.getCurrentSession()) {

            Transaction transaction = session.beginTransaction();

            Doctor doctor = session.get(Doctor.class, id);
            transaction.commit();

            return doctor;
        }
    }
}






