package com.laptrinhjavaweb.repository.jdbc.entity;

import com.laptrinhjavaweb.repository.jdbc.annotation.ColumnJDBC;
import com.laptrinhjavaweb.repository.jdbc.annotation.EntityJDBC;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EntityJDBC
public class BaseEntity {

    @ColumnJDBC(name = "id")
    private Long id;
}
