package org.somrainc.com;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConf {

    @Autowired
    @Bean(name="sessionFactory")
    public SessionFactory sessionFactory(HibernateEntityManagerFactory factory) {
        return factory.getSessionFactory();
    }

}
