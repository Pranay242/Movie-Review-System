package com.prog.repository;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public interface MySQLConnection {
    NamedParameterJdbcTemplate getNamedParameterJdbcTemplate();
}
