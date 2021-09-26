package com.laptrinhjavaweb.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class StaffBuildingRequest {
    private LinkedList<Long> staffIds;
    private Long buildingId;

}
