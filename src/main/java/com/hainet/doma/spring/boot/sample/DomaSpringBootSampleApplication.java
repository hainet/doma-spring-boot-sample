package com.hainet.doma.spring.boot.sample;

import com.hainet.doma.spring.boot.sample.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DomaSpringBootSampleApplication implements CommandLineRunner {

    private final PersonDao dao;

    @Autowired
    public DomaSpringBootSampleApplication(PersonDao dao) {
        this.dao = dao;
    }

    public static void main(String[] args) {
        SpringApplication.run(DomaSpringBootSampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        dao.findAll().forEach(it -> {
            System.out.println(it.id);
            System.out.println(it.name);
        });
    }
}
