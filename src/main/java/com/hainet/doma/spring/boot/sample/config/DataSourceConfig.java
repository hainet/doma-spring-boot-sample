package com.hainet.doma.spring.boot.sample.config;

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
                .setName("data-source1")
                .setType(EmbeddedDatabaseType.H2)
                .addScripts(
                        "schema-datasource1.sql",
                        "data-datasource1.sql")
                .build();
    }

    @Bean
    public DataSource dataSource2() {
        return new EmbeddedDatabaseBuilder()
                .setName("data-source2")
                .setType(EmbeddedDatabaseType.H2)
                .addScripts(
                        "schema-datasource2.sql",
                        "data-datasource2.sql")
                .build();
    }
}
