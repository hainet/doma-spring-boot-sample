package com.hainet.doma.spring.boot.sample.domain.dao;

import com.hainet.doma.spring.boot.sample.config.annotation.ConfigAutowireableDataSource2;
import com.hainet.doma.spring.boot.sample.domain.entity.Model2;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import java.util.List;

@ConfigAutowireableDataSource2
@Dao
public interface Model2Dao {

    @Select
    List<Model2> findAll();
}
