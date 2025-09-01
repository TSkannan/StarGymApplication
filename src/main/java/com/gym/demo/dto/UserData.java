package com.gym.demo.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "UserData")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userName", length = 64, nullable = false)
    private String username;

    @Column(name = "password", length = 64, nullable = false)
    private String password;

    @OneToOne(mappedBy = "userData", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserRoleData userRole;
}
