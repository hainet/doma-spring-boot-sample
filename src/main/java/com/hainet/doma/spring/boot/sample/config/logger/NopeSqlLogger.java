package com.hainet.doma.spring.boot.sample.config.logger;

import org.seasar.doma.jdbc.Sql;
import org.seasar.doma.jdbc.UtilLoggingJdbcLogger;
import org.springframework.stereotype.Component;

@Component
public class NopeSqlLogger extends UtilLoggingJdbcLogger {

    @Override
    public void logSql(
            final String callerClassName,
            final String callerMethodName,
            final Sql<?> sql) {
        // Nope
    }
}
