package com.gym.demo.dto;

import lombok.Data;

@Data
public class UserDetails {

    private Long userId;
    private String username;
    private Long roleId;
    private String roleName;

}
