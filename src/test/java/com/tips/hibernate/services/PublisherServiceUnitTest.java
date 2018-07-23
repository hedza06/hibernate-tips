package com.tips.hibernate.services;

import com.tips.hibernate.entities.Publisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublisherServiceUnitTest {

    @Autowired
    private PublisherService publisherService;


    @Test
    public void fetchRegularFullNameTest()
    {
        Optional<Publisher> optionalPublisher = publisherService.findOneByFirstName("Heril");
        if (optionalPublisher.isPresent())
        {
            Publisher publisher = optionalPublisher.get();
            assertThat(publisher.getFirstName()).isEqualTo("Heril");
            assertThat(publisher.getLastName()).isEqualTo("Muratovic");
            assertThat(publisher.getFullName()).isEqualTo("Heril Muratovic");
        }
    }

    @Test
    public void fetchFullNameFormulaTest()
    {
        Optional<Publisher> optionalPublisher = publisherService.findOneByFirstName("Marko");
        if (optionalPublisher.isPresent())
        {
            Publisher publisher = optionalPublisher.get();
            assertThat(publisher.getFullName()).isEqualTo("Marko Markovic");
        }
    }
}
