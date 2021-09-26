package com.laptrinhjavaweb.utils;

import com.laptrinhjavaweb.constant.SystemConstant;

import java.util.HashMap;
import java.util.Map;

public class MasterDataUtils {

    public Map<String, String> getDistrict(){
        Map<String, String> result = new HashMap<>();
        result.put(SystemConstant.CODE_Q1, SystemConstant.NAME_Q1);

        return result;
    }
}
