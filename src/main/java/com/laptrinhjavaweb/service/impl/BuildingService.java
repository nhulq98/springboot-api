package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.response.BuildingResponse;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.jdbc.impl.BuildingJDBC;
import com.laptrinhjavaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
//@Component
public class BuildingService implements IBuildingService {

    BuildingJDBC buildingJDBC = new BuildingJDBC();
    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingConverter buildingConverter;

    @Override
    public Map<String, String> getDistricts() {
        Map<String, String> districts = new HashMap<>();
        for (DistrictsEnum item : DistrictsEnum.values()) {
            districts.put(item.toString(), item.getDistrictValue());
        }
        return districts;
    }

    @Override
    public Map<String, String> getBuildingTypes() {
        Map<String, String> buildingTypes = new HashMap<>();
        for (BuildingTypesEnum item : BuildingTypesEnum.values()) {
            buildingTypes.put(item.toString(), item.getBuildingTypeValue());
        }
        return buildingTypes;
    }

    @Override
    public BuildingDTO getOne(Long id) {
        try {
            BuildingEntity entity = buildingRepository.findById(id).get();
            return buildingConverter.convertEntityToDTO(entity);
        } catch (NoSuchElementException e) {
            return new BuildingDTO();
        }
    }

    @Override
    public List<BuildingResponse> findByCondition(Map<String, Object> requestParam) {
        //mapper.
        List<BuildingEntity> entities = buildingRepository.findByCondition(requestParam);
        List<BuildingResponse> result = new ArrayList<>();
        for (BuildingEntity entity : entities) {
            BuildingDTO dto = buildingConverter.convertEntityToDTO(entity);
            result.add(buildingConverter.convert(dto, new BuildingResponse()));
        }
        return result;
    }

    @Override
    public BuildingDTO save(BuildingDTO newBuilding) {
        return buildingConverter.convertEntityToDTO(
                buildingRepository.save(
                        buildingConverter.convert(newBuilding, new BuildingEntity())
                )
        );
    }

    /*
    // for change data
    @Override
    @Transactional
    public BuildingDTO save(BuildingDTO newBuilding) {
*//*        int a = 10, b = 2;
        if (a != 0 && b == 0) {
            throw new DivideByZeroException("Không thể nào chia cho 0");
        }*//*
        BuildingEntity buildingEntity = buildingConverter.convertDTOToEntity(newBuilding);
        return buildingConverter.convertEntityToDTO(buildingRepository.save(buildingEntity));
    }*/
}
