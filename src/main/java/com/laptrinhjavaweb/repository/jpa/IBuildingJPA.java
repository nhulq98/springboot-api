package com.laptrinhjavaweb.repository.jpa;

import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.entity.BuildingEntity;

public interface IBuildingJPA {
    void saveJPA(BuildingEntity entity);
    BuildingEntity updateJPA(BuildingEntity entity);
    void deleteAssignmentStaffs(BuildingEntity entity);
}
