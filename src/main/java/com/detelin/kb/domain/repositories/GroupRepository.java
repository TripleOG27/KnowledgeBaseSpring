package com.detelin.kb.domain.repositories;

import com.detelin.kb.domain.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group,String> {
    @Override
    List<Group> findAll();
    @Override
    Optional<Group> findById(String id);

//    Optional<Group> findGroupByMemberId(String id);
}
