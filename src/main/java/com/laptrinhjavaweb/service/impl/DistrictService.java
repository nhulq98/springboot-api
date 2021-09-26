package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.enums.DistrictsEnum;
import com.laptrinhjavaweb.service.IDistrictService;

import java.util.HashMap;
import java.util.Map;

public class DistrictService implements IDistrictService {

    @Override
    public Map<String, String> findAll() {
        Map<String, String> result = new HashMap<>();
        for(DistrictsEnum item: DistrictsEnum.values()){
            result.put(item.toString(), item.getDistrictValue());
        }
        return result;
    }
}
