package com.laptrinhjavaweb.mapper;


import com.laptrinhjavaweb.dto.AbstractDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;

import java.sql.ResultSet;
import java.util.List;

public class BuildingMapper extends AbstractDTO implements IRowMapper<BuildingEntity> {
    @Override
    public BuildingEntity mapRow(ResultSet resultSet) {
        try {
            BuildingEntity buildingEntity = new BuildingEntity();
            buildingEntity.setId(resultSet.getLong("id"));
            buildingEntity.setName(resultSet.getString("name"));
            //buildingEntity.setDistrictId(resultSet.getLong("districtid"));
            buildingEntity.setStreet(resultSet.getString("street"));
            buildingEntity.setWard(resultSet.getString("ward"));
            buildingEntity.setManagerPhone(resultSet.getString("managerphone"));
            buildingEntity.setManagerName(resultSet.getString("managername"));
            buildingEntity.setServiceFee(resultSet.getString("servicefee"));
            buildingEntity.setFloorArea(resultSet.getInt("floorarea"));

            return buildingEntity;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new BuildingEntity();
        }
    }

}
