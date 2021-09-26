package com.laptrinhjavaweb.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuildingResponse extends BaseResponse{
	private String name;
	private String address;
	private String managerName;
	private String managerPhone;
	private Integer floorArea;
	private Integer rentPrice;
	private Integer serviceFee;
}
