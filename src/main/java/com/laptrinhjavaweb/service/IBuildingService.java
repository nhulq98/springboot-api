package com.laptrinhjavaweb.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.BuildingRequest;
import com.laptrinhjavaweb.dto.response.BuildingResponse;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.exception.DivideByZeroException;

public interface IBuildingService {
	//JDBC
	//get Data
/*	List<BuildingDTO> findAll();
	List<BuildingResponse> findByCondition(BuildingRequest buildingRequest);
	BuildingDTO getOne(Long id) throws DivideByZeroException, SQLException;

	//Change Data
	BuildingDTO save(BuildingDTO newBuilding);*/

	//spring data JPA
	//get Data
	List<BuildingResponse> findByCondition(Map<String, Object> requestParam);
	BuildingDTO getOne(Long id);

	//Change Data
	BuildingDTO save(BuildingDTO newBuilding);
//==============================================
	Map<String, String> getDistricts();
	Map<String, String> getBuildingTypes();
}
