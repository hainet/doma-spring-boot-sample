package com.hainet.doma.spring.boot.sample.domain.dao;

import com.hainet.doma.spring.boot.sample.domain.dao.PersonDao;
import com.hainet.doma.spring.boot.sample.domain.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonDaoTest {

    @Autowired
    private PersonDao dao;

    private Person person;

    {
        person = new Person();
        person.setId(1);
        person.setName("hainet");
    }

    @Test
    public void findAllTest() {
        assertThat(dao.findAll(), is(Arrays.asList(person)));
    }
}
