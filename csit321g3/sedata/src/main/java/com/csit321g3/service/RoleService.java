package com.csit321g3.service;

import com.csit321g3.entity.Role;
import com.csit321g3.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import javax.naming.NameNotFoundException;

@Service 
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role postRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @SuppressWarnings("finally")
    public Role putRoleById(Integer role_id, Role newRole) {
        Role role = new Role();
        try {
            role = roleRepository.findById(role_id).get();
            role.setRole_name(newRole.getRole_name());
        } catch (NoSuchElementException e) {
            throw new NameNotFoundException("Role with ID " + role_id + " not found.");
        } finally {
            return roleRepository.save(role);
        }
    }

    public String deleteRoleById(Integer role_id) {
        String message = "";
       
        if(roleRepository.findById(role_id) != null) {
            roleRepository.deleteById(role_id);
            message = "Role with ID " + role_id + " has been deleted.";
        } else {
            message = "Role with ID " + role_id + " not found.";

        }
        return message;
        
    }

    
}