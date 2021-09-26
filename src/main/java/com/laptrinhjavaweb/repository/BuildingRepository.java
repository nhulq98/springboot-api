package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface BuildingRepository extends BuildingRepositoryCustom, JpaRepository<BuildingEntity, Long> {
//    List<BuildingEntity> findByNameContainingIgnoreCase(String name);
//    boolean existsRentAreas_Id(Long id); // find Areas by RentAreasId
     long countByNameContaining(String lastname);
}
