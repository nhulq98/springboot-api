package com.laptrinhjavaweb.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseErrorData {
    private String status;
    private Object data;
}
