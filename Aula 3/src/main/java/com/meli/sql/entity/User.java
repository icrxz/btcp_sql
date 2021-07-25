package com.meli.sql.entity;

import com.meli.sql.entity.enums.UserStatusEnum;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String name;

    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    private UserStatusEnum status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String user_name) {
        this.name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum user_status) {
        this.status = user_status;
    }

    public User() {
    }

    public User(String name, String password, UserStatusEnum status) {
        this.name = name;
        this.password = password;
        this.status = status;
    }
}
