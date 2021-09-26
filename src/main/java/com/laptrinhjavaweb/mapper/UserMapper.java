package com.laptrinhjavaweb.mapper;

import com.laptrinhjavaweb.entity.UserEntity;

import java.sql.ResultSet;

public class UserMapper implements IRowMapper<UserEntity> {

    @Override
    public UserEntity mapRow(ResultSet resultSet) {
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(resultSet.getLong("id"));
            userEntity.setFullName(resultSet.getString("fullname"));

            return userEntity;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new UserEntity();
        }
    }
}
