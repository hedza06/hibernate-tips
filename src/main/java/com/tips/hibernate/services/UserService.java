package com.tips.hibernate.services;

import com.tips.hibernate.entities.User;
import com.tips.hibernate.enumerations.UserType;
import com.tips.hibernate.repositories.UserRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;


    @Transactional(readOnly = true)
    public User findByJmbg(String jmbg)
    {
        Session session = entityManager.unwrap(Session.class);
        return session.bySimpleNaturalId(User.class).load(jmbg);
    }

    /**
     * Method for getting user by type
     *
     * @param userType - provided user type enum value
     * @return User entity
     */
    public User findByUserType(UserType userType) {
        return userRepository.findOneByUserType(userType);
    }
}
