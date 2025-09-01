package com.gym.demo.service;

import com.gym.demo.dto.RoleData;
import com.gym.demo.dto.SaveUserDet;
import com.gym.demo.dto.UserData;
import com.gym.demo.dto.UserRoleData;
import com.gym.demo.repo.RoleRepository;
import com.gym.demo.repo.UserRepository;
import com.gym.demo.repo.UserRoleDataRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    @Autowired
    private UserRoleDataRepository userRoleDataRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public void createUserWithRole(SaveUserDet userDet) {
        if(userDet==null){
            throw new RuntimeException("User details can not be null");
        }
        UserData userData = new UserData();
        userData.setUsername(userDet.getUserName());
        userData.setPassword(userDet.getPassword());
        userData = userRepository.save(userData);

        RoleData roleData = roleRepository.findByRoleName(userDet.getRoleName());
        if (roleData==null){
            throw new RuntimeException("Role not found: "+ userDet.getRoleName());
        }

        UserRoleData userRoleData = new UserRoleData();
        userRoleData.setUserData(userData);
        userRoleData.setRoleData(roleData);
        userRoleDataRepository.save(userRoleData);
    }
}
