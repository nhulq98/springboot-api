package com.laptrinhjavaweb.repository.jdbc.impl;

import com.laptrinhjavaweb.repository.jdbc.IRentTypeJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeJDBCImpl extends BaseJDBCImpl implements IRentTypeJDBC {

    private Connection connection;
    private PreparedStatement prStatement;
    private ResultSet resultSet;

//    @Override
//    public List<RentTypeEntity> findAll() {
//        List<RentTypeEntity> results = new ArrayList<>();
//        String sql = "SELECT * FROM renttype";
//        try {
//            this.connection = super.getConnection();
//            this.connection.setAutoCommit(false);
//            this.prStatement = this.connection.prepareStatement(sql);
//
//            this.resultSet = this.prStatement.executeQuery();
//            while (this.resultSet.next()) {
//                // get All data from resultset
//                results.add(this.convertResultSetToEntity(resultSet));
//            }
//            this.connection.commit();
//            return results;
//
//        } catch (SQLException e) {
//            try {
//                if (this.connection != null) {
//                    this.connection.rollback();
//                    e.printStackTrace();
//                }
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            }
//
//            return null;
//        } finally {
//            closeAll(this.connection, this.prStatement, this.resultSet);
//        }
//    }
//
//    @Override
//    public RentTypeEntity convertResultSetToEntity(ResultSet resultSet) {
//        try {
//            RentTypeEntity rentTypeEntity = new RentTypeEntity();
//            rentTypeEntity.setName(resultSet.getString("name"));
//            rentTypeEntity.setCode(resultSet.getString("code"));
//            rentTypeEntity.setId(resultSet.getLong("id"));
//
//            return rentTypeEntity;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }
}
