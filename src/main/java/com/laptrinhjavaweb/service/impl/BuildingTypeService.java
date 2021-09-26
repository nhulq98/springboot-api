package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.service.IBuildingTypeService;

import java.util.HashMap;
import java.util.Map;

public class BuildingTypeService implements IBuildingTypeService {

    @Override
    public Map<String, String> findAll() {
        Map<String, String> buildingTypes = new HashMap<>();
        for (BuildingTypesEnum item : BuildingTypesEnum.values()) {
            buildingTypes.put(item.toString(), item.getBuildingTypeValue());
        }
        return buildingTypes;
    }

}
