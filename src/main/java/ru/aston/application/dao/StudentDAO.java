package ru.aston.application.dao;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.aston.application.entity.StudentEntity;

import javax.sql.DataSource;

@Repository
public class StudentDAO {

    private final SessionFactory sessionFactory;

    public StudentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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
