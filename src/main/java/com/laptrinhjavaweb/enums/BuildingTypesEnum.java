package com.laptrinhjavaweb.enums;

public enum BuildingTypesEnum {
	
	TANG_TRET("Tầng trệt"),  
    NGUYEN_CAN("Nguyên căn"),  
    NOI_THAT("Nội thất");
	
    private final String buildingTypeValue;

    BuildingTypesEnum(String buildingTypeValue) {
        this.buildingTypeValue = buildingTypeValue;
    }

	public String getBuildingTypeValue() {
		return buildingTypeValue;
	}
}
