package com.laptrinhjavaweb.repository.jdbc;

import com.laptrinhjavaweb.entity.UserEntity;

import java.util.List;

public interface IAssignmentBuildingJDBC {

    //Get data
    List<UserEntity> getAllStaffs();
    List<UserEntity> findStaffsByBuildingId(Long buildingId);

    // for change data
    void deleteStaffOfBuildingById(Long buildingId, Long staffId);
    Long insertStaffOfBuildingById(Long buildingId, Long staffId);
}
