package com.hainet.doma.spring.boot.sample.config;

import com.hainet.doma.spring.boot.sample.config.annotation.DataSource1;
import com.hainet.doma.spring.boot.sample.config.annotation.DataSource2;
import org.seasar.doma.boot.autoconfigure.DomaConfig;
import org.seasar.doma.boot.autoconfigure.DomaConfigBuilder;
import org.seasar.doma.boot.autoconfigure.DomaProperties;
import org.seasar.doma.jdbc.EntityListenerProvider;
import org.seasar.doma.jdbc.JdbcLogger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class SpringDomaConfig {

    private final DataSource dataSource;

    private final DataSource dataSource1;

    private final DataSource dataSource2;

    private final DomaProperties domaProperties;

    private final JdbcLogger jdbcLogger;

    public SpringDomaConfig(
            @Qualifier("dataSource") final DataSource dataSource,
            @Qualifier("dataSource1") final DataSource dataSource1,
            @Qualifier("dataSource2") final DataSource dataSource2,
            final DomaProperties domaProperties,
            final JdbcLogger jdbcLogger) {
        this.dataSource = dataSource;
        this.dataSource1 = dataSource1;
        this.dataSource2 = dataSource2;
        this.domaProperties = domaProperties;
        this.jdbcLogger = jdbcLogger;
    }

    @Bean
    @Primary
    public DomaConfig config() {
        return new org.seasar.doma.boot.autoconfigure.DomaConfig(
                new DomaConfigBuilder()
                        .dataSource(dataSource)
                        .dialect(domaProperties.getDialect().create())
                        .sqlFileRepository(domaProperties.getSqlFileRepository().create())
                        .naming(domaProperties.getNaming().naming())
                        .entityListenerProvider(new EntityListenerProvider() {
                        }),
                domaProperties
        );
    }

    @Bean
    @DataSource1
    public DomaConfig config1() {
        return new org.seasar.doma.boot.autoconfigure.DomaConfig(
                new DomaConfigBuilder()
                        .dataSource(dataSource1)
                        .dialect(domaProperties.getDialect().create())
                        .sqlFileRepository(domaProperties.getSqlFileRepository().create())
                        .naming(domaProperties.getNaming().naming())
                        .entityListenerProvider(new EntityListenerProvider() {
                        }),
                domaProperties
        );
    }

    @Bean
    @DataSource2
    public DomaConfig config2() {
        return new org.seasar.doma.boot.autoconfigure.DomaConfig(
                new DomaConfigBuilder()
                        .dataSource(dataSource2)
                        .dialect(domaProperties.getDialect().create())
                        .sqlFileRepository(domaProperties.getSqlFileRepository().create())
                        .naming(domaProperties.getNaming().naming())
                        .entityListenerProvider(new EntityListenerProvider() {
                        })
                        .jdbcLogger(jdbcLogger),
                domaProperties
        );
    }
}
