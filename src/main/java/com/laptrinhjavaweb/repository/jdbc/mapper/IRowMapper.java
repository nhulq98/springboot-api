package com.laptrinhjavaweb.repository.jdbc.mapper;

import java.sql.ResultSet;

public interface IRowMapper<T> {

    T mapRow(ResultSet resultSet);
}
