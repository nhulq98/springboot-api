package com.laptrinhjavaweb.repository.jdbc.impl;

import com.laptrinhjavaweb.mapper.DistrictMapper;
import com.laptrinhjavaweb.repository.jdbc.IDistrictJDBC;

import java.sql.ResultSet;
import java.util.List;

public class DistrictJDBCImpl extends BaseJDBCImpl implements IDistrictJDBC{

//    @Override
//    public DistrictEntity findById(Long id) {
//        List<DistrictEntity> entityList = query("SELECT code, name FROM district WHERE id = ?", new DistrictMapper(), id);
//        return entityList.size() > 0 ? entityList.get(0) : new DistrictEntity();
//    }
//
//    @Override
//    public DistrictEntity convertResultSetToEntity(ResultSet resultSet) {
//        try {
//            DistrictEntity districtEntity = new DistrictEntity();
//            districtEntity.setName(resultSet.getString("name"));
//            districtEntity.setCode(resultSet.getString("code"));
//
//            return districtEntity;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return new DistrictEntity();
//        }
//    }
}
