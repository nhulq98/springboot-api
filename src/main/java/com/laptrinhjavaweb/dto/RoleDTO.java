package com.laptrinhjavaweb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDTO extends AbstractDTO<RoleDTO> {
    private String name;
    private String code;
}
