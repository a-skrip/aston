package ru.aston.hw003.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.aston.hw003.entity.CourseEntity;
import ru.aston.hw003.utils.HibernateUtil;

public class CourseDAO {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

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