package com.laptrinhjavaweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "street")
    private String street;

    @Column(name = "ward")
	private String ward;
	//==============================relationship==============================

	@OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
	List<AssignmentBuildingEntity> assignmentBuildings = new ArrayList<>();

	//@OneToMany //đọc là: @ 1 entity(this class) To many entity(below variable)
	@OneToMany(mappedBy = "building")// @OneToMany thì dùng mappedby = tên đối tượng khai báo bên bảng mà ta liên kết. Ở đây là rentarea
	private List<RentAreaEntity> rentAreas = new ArrayList<>();// khai báo đối tượng quan hệ

	//========================================================================

	@Column(name = "structure")
	private String structure;

	@Column(name = "numberofbasement")
	private Integer numberOfBasement;

    @Column(name = "floorarea")
    private Integer floorArea;

	@Column(name = "direction")
	private Integer direction;

	@Column(name = "level")
	private String level;

    @Column(name = "rentprice")
	private Integer rentPrice;

	@Column(name = "rentpricedescription")
	private String rentPriceDescription;

	@Column(name = "servicefee")
	private String serviceFee;

	@Column(name = "carfee")
	private String carFee;

	@Column(name = "motofee")
	private String motoFee;

	@Column(name = "overtimefee")
	private String overtimeFee;

	@Column(name = "waterfee")
	private String waterFee;

	@Column(name = "electricityfee")
	private String electricityFee;

	@Column(name = "deposit")
	private String deposit;

	@Column(name = "payment")
	private String payment;

	@Column(name = "renttime")
	private String rentTime;

	@Column(name = "decorationtime")
	private String decorationTime;

	@Column(name = "brokeragefee")
	private String brokerageFee;

	@Column(name = "note")
	private String note;

	@Column(name = "linkofbuilding")
	private String linkOfBuilding;

	@Column(name = "map")
	private String map;

	@Column(name = "avatar")
	private String avatar;

    @Column(name = "managername")
	private String managerName;

    @Column(name = "managerphone")
	private String managerPhone;

	@Column(name = "type")
	private String rentType;

	@Column(name = "district")
	private String districtCode;
}
