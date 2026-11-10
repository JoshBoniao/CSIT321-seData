package com.csit321g3.repository;
import com.csit321g3.entity.Role;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}