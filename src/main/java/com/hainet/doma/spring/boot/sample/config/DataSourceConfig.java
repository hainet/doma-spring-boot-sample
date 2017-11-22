package com.hainet.doma.spring.boot.sample.config;

import com.hainet.doma.spring.boot.sample.config.annotation.DataSource1;
import com.hainet.doma.spring.boot.sample.config.annotation.DataSource2;
import org.seasar.doma.boot.autoconfigure.DomaConfig;
import org.seasar.doma.boot.autoconfigure.DomaConfigBuilder;
import org.seasar.doma.boot.autoconfigure.DomaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setName("doma-spring-boot-sample")
                .setType(EmbeddedDatabaseType.H2)
                .addDefaultScripts()
                .build();
    }

    @Bean
    public DataSource dataSource1() {
        return new EmbeddedDatabaseBuilder()
                .setName("datasource1")
                .setType(EmbeddedDatabaseType.H2)
                .addScripts(
                        "schema-datasource1.sql",
                        "data-datasource1.sql")
                .build();
    }

    @Bean
    public DataSource dataSource2() {
        return new EmbeddedDatabaseBuilder()
                .setName("datasource2")
                .setType(EmbeddedDatabaseType.H2)
                .addScripts(
                        "schema-datasource2.sql",
                        "data-datasource2.sql")
                .build();
    }

    @Bean
    @Primary
    public DomaConfig config(final DomaProperties domaProperties) {
        return new DomaConfig(
                new DomaConfigBuilder()
                        .dataSource(dataSource())
                        .dialect(domaProperties.getDialect().create())
                        .sqlFileRepository(domaProperties.getSqlFileRepository().create())
                        .naming(domaProperties.getNaming().naming()),
                domaProperties);
    }

    @Bean
    @DataSource1
    public DomaConfig config1(final DomaProperties domaProperties) {
        System.out.println(domaProperties);

        return new DomaConfig(
                new DomaConfigBuilder()
                        .dataSource(dataSource1())
                        .dialect(domaProperties.getDialect().create())
                        .sqlFileRepository(domaProperties.getSqlFileRepository().create())
                        .naming(domaProperties.getNaming().naming()),
                domaProperties);
    }

    @Bean
    @DataSource2
    public DomaConfig config2(final DomaProperties domaProperties) {
        return new DomaConfig(
                new DomaConfigBuilder()
                        .dataSource(dataSource2())
                        .dialect(domaProperties.getDialect().create())
                        .sqlFileRepository(domaProperties.getSqlFileRepository().create())
                        .naming(domaProperties.getNaming().naming()),
                domaProperties);
    }
}
