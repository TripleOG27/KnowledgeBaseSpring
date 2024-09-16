package com.detelin.kb.services;

import com.detelin.kb.GlobalConstants;
import com.detelin.kb.domain.entities.Role;
import com.detelin.kb.domain.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;

    @Override
    public void seedRolesInDB() {
        if(this.roleRepository.count()==0){
            this.roleRepository.save(new Role(GlobalConstants.AUTHOR_ROLE));
            this.roleRepository.save(new Role(GlobalConstants.EDITOR_ROLE));
            this.roleRepository.save(new Role(GlobalConstants.GUEST_ROLE));
            this.roleRepository.save(new Role(GlobalConstants.ROOT_ROLE));
        }
    }


    @Override
    public Set<Role> findAllRoles() {
        return new HashSet<>(this.roleRepository.findAll());
    }

    @Override
    public Role findByAuthority(String authority) {
        return this.roleRepository.findByAuthority(authority);
    }
}
