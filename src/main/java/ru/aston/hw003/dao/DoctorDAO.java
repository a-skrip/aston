package ru.aston.hw003.dao;

import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.query.QueryParameter;
import ru.aston.hw003.entity.Doctor;
import ru.aston.hw003.utils.HibernateUtil;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;


public class DoctorDAO {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


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






