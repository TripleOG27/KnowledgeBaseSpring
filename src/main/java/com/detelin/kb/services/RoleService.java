package com.detelin.kb.services;

import com.detelin.kb.domain.entities.Role;
import com.detelin.kb.domain.models.service.RoleServiceModel;

import java.util.Set;

public interface RoleService {

    void seedRolesInDB();
    Set<Role> findAllRoles();
    Role findByAuthority(String authority);

}
