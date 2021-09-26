package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.entity.UserEntity;

import java.util.LinkedList;
import java.util.List;

public interface AssignmentBuildingRepositoryCustom {
    //Get data
    List<UserEntity> getAllStaffs();
   // LinkedList<UserEntity> findStaffsByBuildingId(Long buildingId);

    // for change data
    int deleteStaffOfBuildingById(Long buildingId, Long staffId);
    int insertStaffOfBuildingById(Long buildingId, Long staffId);

}
