package com.laptrinhjavaweb.entity;

import javax.persistence.*;

/*
@Getter
@Setter
@Entity
@Table(name = "user_role")*/
public class UserRoleEntity extends BaseEntity {

/*
    @Column(name = "roleid", nullable = false)
    private Long roleId;

    @Column(name = "userid", nullable = false)
    private Long userId;

    //relationship
    @ManyToOne// khai báo kiểu quan hệ
    @JoinColumn(name = "roleid", nullable = false, referencedColumnName="id", insertable=false, updatable=false)// Khai báo TÊN khóa ngoại của bảng này sẽ liên kết với đối tượng bên dưới
    private RoleEntity role; // khai báo đối tượng quan hệ

    @ManyToOne// khai báo kiểu quan hệ
    @JoinColumn(name = "userid", nullable = false, referencedColumnName="id", insertable=false, updatable=false)// Khai báo TÊN khóa ngoại của bảng này sẽ liên kết với đối tượng bên dưới
    private UserEntity user; // khai báo đối tượng quan hệ
*/

}
