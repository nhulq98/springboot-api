package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.repository.custom.AssignmentBuildingRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public interface AssignmentBuildingRepository extends AssignmentBuildingRepositoryCustom, JpaRepository<AssignmentBuildingEntity, Long> {
    List<AssignmentBuildingEntity> findAllByBuildingId(Long id);
}
