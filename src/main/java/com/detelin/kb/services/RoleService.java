package com.detelin.kb.services;

import com.detelin.kb.domain.models.service.RoleServiceModel;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface RoleService {

    void seedRolesInDB();
    Set<RoleServiceModel> findAllRoles();
    RoleServiceModel findByAuthority(String authority);

}
