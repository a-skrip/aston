package ru.aston.application.config;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.aston.application.dao.DoctorDAO;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ru.aston.application")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public SessionFactory sessionFactory() {
        try {
            StandardServiceRegistry standartServiceRegistry = new StandardServiceRegistryBuilder()
                    .configure().build();
            Metadata metadata = new MetadataSources(standartServiceRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();
        } catch (HibernateException he) {
            System.out.println("Session Factory creation failure");
            throw he;
        }
    }
}
