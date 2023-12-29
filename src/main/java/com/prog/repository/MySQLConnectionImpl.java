package com.prog.repository;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

@Service
public class MySQLConnectionImpl implements MySQLConnection {

    private static NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;
    private static final Object o = new Object();

    @Override
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        synchronized (o) {
            if(namedParameterJdbcTemplate == null) {
                DriverManagerDataSource dataSource = new DriverManagerDataSource();
                dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
                dataSource.setUrl("jdbc:mysql://localhost:3306/moviereviewsystem");
                dataSource.setUsername("root");

                // Create NamedParameterJdbcTemplate using the data source
                namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
            }
            return namedParameterJdbcTemplate;
        }
    }
}
