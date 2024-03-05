package ru.aston.hw003.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.aston.hw003.entity.StudentEntity;
import ru.aston.hw003.utils.HibernateUtil;

public class StudentDAO {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public StudentEntity getStudentByID(long id) {
        try (Session session = sessionFactory.getCurrentSession()) {

            Transaction transaction = session.beginTransaction();
            StudentEntity student = session.get(StudentEntity.class, id);
            transaction.commit();

            return student;
        }

    }

    public void addStudent(StudentEntity student) {

        try (Session session = sessionFactory.getCurrentSession()) {

            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();

        }
    }

    public void deleteStudent(long id) {

        try (Session session = sessionFactory.getCurrentSession()) {

            Transaction transaction = session.beginTransaction();
            StudentEntity studentEntity = session.get(StudentEntity.class, id);
            session.delete(studentEntity);
            transaction.commit();

        }
    }

}
