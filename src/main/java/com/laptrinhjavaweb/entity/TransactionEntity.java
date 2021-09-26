package com.laptrinhjavaweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "transaction")
public class TransactionEntity extends BaseEntity {

    @Column(name = "note")
    private String note;

    @Column(name = "code")
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)// khai báo kiểu quan hệ
    @JoinColumn(name = "customerid")// Khai báo TÊN khóa ngoại của bảng này sẽ liên kết với đối tượng bên dưới
    private CustomerEntity customer = new CustomerEntity(); // khai báo đối tượng quan hệ
}
