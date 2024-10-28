package uth.edu.podbooking.domain.account.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String img;

    @Column(name = "is_acctive", nullable = false)
    private Boolean isActive;
    @Column(name = "is_vip", nullable = false)
    private Boolean isVip;

//    private Integer userId; // Chỉ lưu trữ ID người dùng

//    private Integer typeId; // Chỉ lưu trữ ID loại tài khoản

    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
