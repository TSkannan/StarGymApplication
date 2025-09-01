package com.gym.demo.controller;

import com.gym.demo.dto.RoleData;
import com.gym.demo.dto.SaveUserDet;
import com.gym.demo.dto.UserDetails;
import com.gym.demo.dto.ValidateUser;
import com.gym.demo.repo.RoleRepository;
import com.gym.demo.repo.UserRepository;
import com.gym.demo.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value= "/gymapi")
public class GymController {

    @Autowired
    UserLoginService userLoginService;
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping(value="/save")
    public String saveUserLogin(@RequestBody SaveUserDet userDet){
            userLoginService.createUserWithRole(userDet);
            return "User Details Successfully Saved";
    }

    @PostMapping(value = "/saveroledata")
    public String saveRoleData(@RequestBody RoleData roleData){
        roleRepository.save(roleData);
        return "Role Details Successfully Saved";
    }

    /*@GetMapping(value="/validateuserlogin")
    public UserDetails validateUserLogin(@RequestBody ValidateUser user){

    }*/
}
