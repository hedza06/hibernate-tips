package com.tips.hibernate.services;

import com.tips.hibernate.entities.User;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional(readOnly = true)
    public User findByJmbg(String jmbg)
    {
        Session session = entityManager.unwrap(Session.class);
        return session.bySimpleNaturalId(User.class).load(jmbg);
    }
}
