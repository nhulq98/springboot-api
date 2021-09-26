package com.laptrinhjavaweb.repository.jdbc.impl;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.mapper.UserMapper;
import com.laptrinhjavaweb.repository.jdbc.IAssignmentBuildingJDBC;

import java.util.List;

public class AssignmentBuildingJDBCImpl extends BaseJDBCImpl implements IAssignmentBuildingJDBC {

    @Override
    public List<UserEntity> getAllStaffs() {
        StringBuilder sql = new StringBuilder("SELECT US.id, US.fullname ")
                .append(" FROM assignmentbuilding ASB ")
                .append(" JOIN user US on US.id = ASB.staffid ")
                .append(" GROUP BY US.id;");
        return query(sql.toString(), new UserMapper());
    }

    @Override
    public List<UserEntity> findStaffsByBuildingId(Long buildingId) {
        StringBuilder sql = new StringBuilder("SELECT US.id, US.fullname ")
                .append(" FROM assignmentbuilding ASB ")
                .append(" JOIN user US on US.id = ASB.staffid ")
                .append(" WHERE buildingid = ? ")
                .append(" GROUP BY US.id;");
        return query(sql.toString(), new UserMapper(), buildingId);
    }

    @Override
    public void deleteStaffOfBuildingById(Long buildingId, Long staffId) {
        String sql = "DELETE FROM assignmentbuilding WHERE buildingid=? AND staffid = ? ";
        this.update(sql, buildingId, staffId);
    }

    @Override
    public Long insertStaffOfBuildingById(Long buildingId, Long staffId) {
        String sql = "INSERT INTO assignmentbuilding(buildingid, staffid)" +
                "VALUES (?, ?);";
        return this.insert(sql, buildingId, staffId);
    }
}
