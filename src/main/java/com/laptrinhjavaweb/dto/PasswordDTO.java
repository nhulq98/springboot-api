package com.laptrinhjavaweb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordDTO extends AbstractDTO<PasswordDTO> {

    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
}
