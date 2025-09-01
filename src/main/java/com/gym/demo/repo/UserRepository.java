package com.gym.demo.repo;

import com.gym.demo.dto.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserData,Long> {
    UserData findByUserNameAndPassword(String userName, String password);
}
