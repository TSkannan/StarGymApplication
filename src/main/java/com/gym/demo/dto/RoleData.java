package com.gym.demo.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "RoleData")
public class RoleData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;

    @OneToMany(mappedBy = "roleData", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserRoleData> userRoles = new HashSet<>();

}
