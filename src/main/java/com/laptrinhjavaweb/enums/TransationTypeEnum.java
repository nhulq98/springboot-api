package com.laptrinhjavaweb.enums;

public enum TransationTypeEnum {
    DAN_DI_XEM("Dẫn Đi Xem");

    private final String buildingTypeValue;

    TransationTypeEnum(String buildingTypeValue) {
        this.buildingTypeValue = buildingTypeValue;
    }

    public String getBuildingTypeValue() {
        return buildingTypeValue;
    }
}
