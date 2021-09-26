package com.laptrinhjavaweb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentEreaDTO extends AbstractDTO<RentEreaDTO>{
	private String value;
	private Long buildingid;
}
