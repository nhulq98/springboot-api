package com.laptrinhjavaweb.repository.jdbc.entity;

import com.laptrinhjavaweb.repository.jdbc.annotation.ColumnJDBC;
import com.laptrinhjavaweb.repository.jdbc.annotation.EntityJDBC;
import com.laptrinhjavaweb.repository.jdbc.annotation.TableJDBC;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EntityJDBC
@TableJDBC(name = "building")
public class BuildingEntity extends BaseEntity{

    @ColumnJDBC(name = "name")
    private String name;

    @ColumnJDBC(name = "street")
    private String street;
}
