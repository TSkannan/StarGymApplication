package com.gym.demo.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "UserRoleData", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"userdata_id"})
})
public class UserRoleData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "userdata_id", nullable = false, referencedColumnName = "id", unique = true)
    private UserData userData;

    @ManyToOne
    @JoinColumn(name = "roledata_id", nullable = false, referencedColumnName = "id", unique = true)
    private RoleData roleData;

}
