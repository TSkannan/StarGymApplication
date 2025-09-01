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
    private String userName;
    private String password;
}
