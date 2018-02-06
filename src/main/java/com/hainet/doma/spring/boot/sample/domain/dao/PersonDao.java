package com.hainet.doma.spring.boot.sample.domain.dao;

import com.hainet.doma.spring.boot.sample.domain.entity.Person;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import java.util.Optional;

@ConfigAutowireable
@Dao
public interface PersonDao {

    @Select
    List<Person> findAll();

    @Select
    Optional<Person> findById(Integer id);

    @Update
    int update(Person person);
}
