package com.detelin.kb.domain.repositories;

import com.detelin.kb.domain.entities.Role;
import com.detelin.kb.domain.entities.User;
import com.detelin.kb.domain.enums.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.config.core.userdetails.UserDetailsMapFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;
//@Repository
//public interface UserRepositoy extends JpaRepository<User,String> {
//    @Autowired
//    Optional<User> findByUsername(String username);
//    @Autowired
//    Optional<User> findById(String id);
//    @Autowired
//    Optional<User> findUserByStatusEqualsAndAuthoritiesContains(UserStatus status, Role role);
//}
