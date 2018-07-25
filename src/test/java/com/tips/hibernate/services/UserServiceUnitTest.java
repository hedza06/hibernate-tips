package com.tips.hibernate.services;

import com.tips.hibernate.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceUnitTest {

    @Autowired
    private UserService userService;

    @Test
    public void findByNaturalId()
    {
        User user = userService.findByJmbg("1401992220013");
        assertThat(user.getJmbg()).isEqualTo("1401992220013");
    }
}
