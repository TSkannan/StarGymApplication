package com.gym.demo.service;

import com.gym.demo.dto.*;
import com.gym.demo.repo.RoleRepository;
import com.gym.demo.repo.UserRepository;
import com.gym.demo.repo.UserRoleDataRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginService {

    private final UserRoleDataRepository userRoleDataRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Transactional
    public void createUserWithRole(SaveUserDet userDet) {
        if (userDet == null) {
            throw new RuntimeException("User details can not be null");
        }
        UserData userData = new UserData();
        userData.setUserName(userDet.getUserName());
        userData.setPassword(userDet.getPassword());
        userData = userRepository.save(userData);

        RoleData roleData = roleRepository.findByRoleName(userDet.getRoleName());
        if (roleData == null) {
            throw new RuntimeException("Role not found: " + userDet.getRoleName());
        }

        UserRoleData userRoleData = new UserRoleData();
        userRoleData.setUserId(userData.getId());
        userRoleData.setRoleId(roleData.getId());
        userRoleData.setRoleName(userDet.getRoleName());
        userRoleDataRepository.save(userRoleData);
    }

    public UserDetails validateUserLogin(ValidateUser user) {
        UserData userData = userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
        if (userData == null) {
            throw new RuntimeException("Invalid user credentials");
        }
        UserRoleData userRoleData = userRoleDataRepository.findByUserId(userData.getId());
        if (userRoleData == null) {
            throw new RuntimeException("User role not found for user: " + user.getUserName());
        }
        UserDetails userDetails = new UserDetails();
        userDetails.setUserName(userData.getUserName());
        userDetails.setRoleName(userRoleData.getRoleName());
        userDetails.setUserId(userData.getId());
        userDetails.setRoleId(userRoleData.getRoleId());
        return userDetails;
    }
}
