package com.laptrinhjavaweb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuildingDTO extends AbstractDTO<BuildingDTO>{

	private String name;
	private String street;
	private String ward;
	private Long districtID;
	private String structure;
	private Integer numberOfBasement;
	private Integer floorArea;
	private String rentAreas;
	private String direction;
	private String level;
	private Integer rentPrice;
	private String rentPriceDescription;
	private String serviceFee;
	private String carFee;
	private String motorbikeFee;
	private String overtimeFee;
	private String waterFee;
	private String electricityFee;
	private String deposit;
	private String payment;
	private String rentTime;
	private String decoratorTime;
	private String brokerageFee;
	private String note;
	private String linkofbuilding;
	private String map;
	private String image;
	private String managerName;
	private String managerPhone;
	private String address;
}
