package com.laptrinhjavaweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "rentarea")
public class RentAreaEntity extends BaseEntity{

    @Column(name = "value")
    private Integer value;

    //relationship
    @ManyToOne()
    @JoinColumn(name = "buildingid")
    private BuildingEntity building = new BuildingEntity();

}
