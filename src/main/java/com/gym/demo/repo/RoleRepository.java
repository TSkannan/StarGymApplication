package com.gym.demo.repo;

import com.gym.demo.dto.RoleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<RoleData, Long> {

    @Query("Select r from RoleData r where r.roleName = :roleName")
    RoleData findByRoleName(@Param("roleName") String roleName);
}
