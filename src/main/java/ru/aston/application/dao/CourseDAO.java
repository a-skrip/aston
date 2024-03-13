package ru.aston.application.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.aston.application.entity.CourseEntity;

@Repository
public class CourseDAO {


    private final SessionFactory sessionFactory;

    public CourseDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public CourseEntity getCourseById(long id) {

        try (Session session = sessionFactory.getCurrentSession()) {

            Transaction transaction = session.beginTransaction();
            CourseEntity course = session.get(CourseEntity.class, id);
            transaction.commit();

            return course;
        }
    }

    public void addCourse(CourseEntity course) {

        try (Session session = sessionFactory.getCurrentSession()) {

            Transaction transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();

        }
    }

    public void deleteCourse(long id) {
        try (Session session = sessionFactory.getCurrentSession()) {

            Transaction transaction = session.beginTransaction();
            CourseEntity course = session.get(CourseEntity.class, id);
            session.delete(course);
            transaction.commit();

        }
    }
}