package com.laptrinhjavaweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    @Column(name = "fullname", nullable = false)
    private String fullName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone", unique = true)
    private String phone;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<AssignmentBuildingEntity> assignmentBuildings = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    // dòng bên dưới tạo ra 1 table có tên là user_role
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "userid", nullable = false),//tạo column có tên userid reference tới cột userid
            inverseJoinColumns = @JoinColumn(name = "roleid", nullable = false)) // tạo column có tên roleid reference tới roleid
    private List<RoleEntity> roles = new ArrayList<>();
}
