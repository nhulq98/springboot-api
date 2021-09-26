package com.laptrinhjavaweb.repository.jdbc;

import com.laptrinhjavaweb.mapper.IRowMapper;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface IBaseJDBC {
	// Get Data
	<T> List<T> query(String sql, IRowMapper<T> objectMapper, Object... parameters);

	// Change Data
	Long insert(String sql, Object ... parameters);
	void update(String sql, Object ... parameters);


//	Connection getConnection();
//	void closeAll(Connection connection, PreparedStatement prStatement, ResultSet resultSet);
//	void setParameters(PreparedStatement prStatement, Object... parameters);
}
