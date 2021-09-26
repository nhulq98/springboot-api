package com.laptrinhjavaweb.builder;

import lombok.Getter;

import java.util.List;

@Getter
public class BuildingSearch {
    private final String name;
    private final String district;
    private final String buildingArea;
    private final String street;
    private final String ward;
    private final Integer numberOfBasement;
    private final List<String> buildingTypes;
    private final Integer costRentFrom;
    private final Integer costRentTo;
    private final Integer areaRentFrom;
    private final Integer areaRentTo;
    private final Long staffId;
    private final String direction;
    private final String level;
    private final String managerName;
    private final String managerphone;

    public BuildingSearch(Builder builder) {
        this.name = builder.name;
        this.district = builder.district;
        this.buildingArea = builder.buildingArea;
        this.numberOfBasement = builder.numberOfBasement;
        this.street = builder.street;
        this.ward = builder.ward;
        this.buildingTypes = builder.buildingTypes;
        this.costRentFrom = builder.costRentFrom;
        this.costRentTo = builder.costRentTo;
        this.areaRentFrom = builder.areaRentFrom;
        this.areaRentTo = builder.areaRentTo;
        this.staffId = builder.staffId;
        this.direction = builder.direction;
        this.level = builder.level;
        this.managerName = builder.managerName;
        this.managerphone = builder.managerphone;
    }
	public static class Builder {

        private String name;
        private String district;
        private String buildingArea;
        private String street;
        private String ward;
        private Integer numberOfBasement;
        private List<String> buildingTypes;
        private Integer costRentFrom;
        private Integer costRentTo;
        private Integer areaRentFrom;
        private Integer areaRentTo;
        private Long staffId;
        private String direction;
        private String level;
        private String managerName;
        private String managerphone;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDistrict(String district) {
            this.district = district;
            return this;
        }

        public Builder setBuildingArea(String buildingArea) {
            this.buildingArea = buildingArea;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setWard(String ward) {
            this.ward = ward;
            return this;
        }

        public Builder setBuildingTypes(List<String> buildingTypes) {
            this.buildingTypes = buildingTypes;
            return this;
        }

        public Builder setNumberOfBasement(Integer numberOfBasement) {
            this.numberOfBasement = numberOfBasement;
            return this;
        }

        public Builder setCostRentFrom(Integer costRentFrom) {
            this.costRentFrom = costRentFrom;
            return this;
        }

        public Builder setCostRentTo(Integer costRentTo) {
            this.costRentTo = costRentTo;
            return this;
        }

        public Builder setAreaRentFrom(Integer areaRentFrom) {
            this.areaRentFrom = areaRentFrom;
            return this;
        }

        public Builder setAreaRentTo(Integer areaRentTo) {
            this.areaRentTo = areaRentTo;
            return this;
        }

        public Builder setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder setDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public Builder setLevel(String level) {
            this.level = level;
            return this;
        }

        public Builder setManagerName(String managerName) {
            this.managerName = managerName;
            return this;
        }

        public Builder setManagerphone(String managerphone) {
            this.managerphone = managerphone;
            return this;
        }

        public BuildingSearch build() {
            return new BuildingSearch(this);
        }

    }
}
