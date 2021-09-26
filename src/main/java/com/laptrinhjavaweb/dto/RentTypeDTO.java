package com.laptrinhjavaweb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentTypeDTO extends AbstractDTO<RentTypeDTO> {
    private String name;
    private String code;
}
