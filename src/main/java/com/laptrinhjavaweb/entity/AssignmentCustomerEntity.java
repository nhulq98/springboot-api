package com.laptrinhjavaweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "assignmentcustomer")
public class AssignmentCustomerEntity extends BaseEntity {

    //relationship
    @ManyToOne(fetch = FetchType.LAZY)// khai báo kiểu quan hệ
    @JoinColumn(name = "staffid")// Khai báo TÊN khóa ngoại của bảng này sẽ liên kết với đối tượng bên dưới
    private UserEntity user = new UserEntity(); // khai báo đối tượng quan hệ
    @ManyToOne(fetch = FetchType.LAZY)// khai báo kiểu quan hệ
    @JoinColumn(name = "customerid")// Khai báo TÊN khóa ngoại của bảng này sẽ liên kết với đối tượng bên dưới
    private CustomerEntity customer = new CustomerEntity(); // khai báo đối tượng quan hệ

}
