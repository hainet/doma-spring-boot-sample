package com.hainet.doma.spring.boot.sample.domain.dao;

import com.hainet.doma.spring.boot.sample.domain.dao.Model2Dao;
import com.hainet.doma.spring.boot.sample.domain.entity.Model2;
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
public class Model2DaoTest {

    @Autowired
    private Model2Dao dao;

    private Model2 model1;

    {
        model1 = new Model2();
        model1.setId(1);
    }

    @Test
    public void findAllTest() {
        assertThat(dao.findAll(), is(Arrays.asList(model1)));
    }
}
