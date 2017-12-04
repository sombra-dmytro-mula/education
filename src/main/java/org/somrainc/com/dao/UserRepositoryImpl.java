package org.somrainc.com.dao;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class UserRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public void customFinder() {
        System.out.println("Do custom scenario");
    }

}
