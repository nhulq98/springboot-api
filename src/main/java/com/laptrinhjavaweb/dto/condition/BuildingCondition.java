package com.laptrinhjavaweb.dto.condition;

import java.util.ArrayList;

import com.laptrinhjavaweb.dto.BuildingTypeDTO;
import com.laptrinhjavaweb.dto.RentEreaDTO;
import com.laptrinhjavaweb.dto.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuildingCondition {
	private String name;
	private String street;
	private String ward;
	private Long districtID;
	private Long floorArea;
	private Long numberOfBasement;
	private String direction;
	private String level;
	private Long rentPriceFrom;
	private Long rentPriceTo;
	private Long rentEreaFrom;
	private Long rentEreaTo;
	private String managerName;
	private String managerPhone;
	private Long userID;
	private ArrayList<String> listType;

}
