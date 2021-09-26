package com.laptrinhjavaweb.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StaffBuildingResponse extends BaseResponse {
    private String checked = "";
    private String fullName;

}
