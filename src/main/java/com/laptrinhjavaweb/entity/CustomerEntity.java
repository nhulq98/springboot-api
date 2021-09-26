package com.laptrinhjavaweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity{

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "phone", unique = true)
    private String phone;

    @Column(name = "email", unique = true)
    private String email;
//=========================================================
    // relationship
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    List<AssignmentCustomerEntity> assignmentCustomers = new ArrayList<>();

    // relationship
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    List<TransactionEntity> transactions = new ArrayList<>();
//============================================================
}
