package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.request.StaffBuildingRequest;
import com.laptrinhjavaweb.dto.response.StaffBuildingResponse;
import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;

import java.util.List;

public interface IAssignmentBuildingService {
    //get Data
    List<StaffBuildingResponse> getAllStaffs();
    List<StaffBuildingResponse> getStaffsOfBuildingById(Long buildingId);// load staff of specifice building
    List<Long> getIdStaffsByBuildingId(Long buildingId);
    List<StaffBuildingResponse> getStaffsAssignment(Long buildingId);

    //Change Data
    void saveAssignmentStaffs(Long buildingId, List<Long> ids);
    void updateAssignment(StaffBuildingRequest request);
    void deleteAssignmentStaffs(Long buildingId, List<Long> ids);




}
