package com.laptrinhjavaweb.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BuildingRequest {
	private String name;
	private String street;
	private String ward;
	private String districtCode;
	private Long districtID;
	private Integer floorArea;
	private Integer numberOfBasement;
	private String direction;
	private String level;
	private Integer rentPriceFrom;
	private Integer rentPriceTo;
	private Integer rentEreaFrom;
	private Integer rentEreaTo;
	private String managerName;
	private String managerPhone;
	private Long userID;
	private List<String> buildingTypeList;
	private String listType;
}
