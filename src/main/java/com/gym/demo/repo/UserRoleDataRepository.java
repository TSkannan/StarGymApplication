package com.gym.demo.repo;

import com.gym.demo.dto.UserRoleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleDataRepository extends JpaRepository<UserRoleData, Long> {


}
