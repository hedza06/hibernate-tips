package com.tips.hibernate.repositories;

import com.tips.hibernate.entities.User;
import com.tips.hibernate.enumerations.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findOneByUserType(UserType userType);

}
