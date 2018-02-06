package com.hainet.doma.spring.boot.sample.domain.dao;

import com.hainet.doma.spring.boot.sample.domain.entity.Person;
import com.hainet.doma.spring.boot.sample.domain.holder.Status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PersonDaoTest {

    @Autowired
    private PersonDao dao;

    private Person person;

    @Before
    public void before() {
        person = new Person();
        person.setId(1);
        person.setName("hainet");
        person.setStatus(Status.ACTIVE);
    }

    @Test
    public void findAllTest() {
        final List<Person> people = dao.findAll();

        assertThat(people, is(Arrays.asList(this.person)));
    }

    @Test
    public void findByIdTest() {
        final Optional<Person> person = dao.findById(1);

        assertThat(person.get(), is(this.person));
    }

    @Test
    public void updateTest() {
        final String name = "updated";
        final Status status = Status.SUSPEND;

        // Setup
        this.person.setName(name);
        this.person.setStatus(status);

        // Exercise
        dao.update(person);

        // Verify
        // TODO: findById以外の方法でupdated後の値にアクセスしたい。
        final Optional<Person> person = dao.findById(1);
        assertThat(person.get(), is(this.person));
    }
}
