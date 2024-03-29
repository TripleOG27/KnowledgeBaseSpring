package com.detelin.kb.services;

import com.detelin.kb.GlobalConstants;
import com.detelin.kb.domain.entities.Role;
import com.detelin.kb.domain.models.service.RoleServiceModel;
import com.detelin.kb.domain.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
@Service
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;
    private final ModelMapper mapper;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper mapper) {
        this.roleRepository = roleRepository;
        this.mapper = mapper;
    }

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
    public Set<RoleServiceModel> findAllRoles() {
        return this.roleRepository.findAll().stream()
                .map(r->this.mapper.map(r,RoleServiceModel.class)).collect(Collectors.toSet());
    }

    @Override
    public RoleServiceModel findByAuthority(String authority) {
        return this.mapper.map(this.roleRepository.findByAuthority(authority),RoleServiceModel.class);
    }
}
