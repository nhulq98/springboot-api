package com.laptrinhjavaweb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DistrictDTO extends AbstractDTO<DistrictDTO> {

    private String code;
    private String name;
}
