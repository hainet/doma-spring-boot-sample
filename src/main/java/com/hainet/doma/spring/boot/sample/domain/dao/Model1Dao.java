package com.hainet.doma.spring.boot.sample.domain.dao;

import com.hainet.doma.spring.boot.sample.config.annotation.ConfigAutowireableDataSource1;
import com.hainet.doma.spring.boot.sample.domain.entity.Model1;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import java.util.List;

@ConfigAutowireableDataSource1
@Dao
public interface Model1Dao {

    @Select
    List<Model1> findAll();
}
