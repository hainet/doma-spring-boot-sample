package com.hainet.doma.spring.boot.sample;

import com.hainet.doma.spring.boot.sample.domain.dao.Model1Dao;
import com.hainet.doma.spring.boot.sample.domain.dao.Model2Dao;
import com.hainet.doma.spring.boot.sample.domain.dao.PersonDao;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class DomaSpringBootSampleApplication implements CommandLineRunner {

    private final PersonDao personDao;
    private final Model1Dao model1Dao;
    private final Model2Dao model2Dao;

    public static void main(String[] args) {
        SpringApplication.run(DomaSpringBootSampleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        personDao.findAll().forEach(System.out::println);
        model1Dao.findAll().forEach(System.out::println);
        model2Dao.findAll().forEach(System.out::println);
    }
}
