package com.csit321g3.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.csit321g3.entity.Role;
import com.csit321g3.service.RoleService;
import java.util.List;



@RestController
@RequestMapping (method = RequestMethod.GET, value = "/role/api")
public class RoleController {
    @Autowired
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/post")
    public Role postRole(@RequestBody Role role) {
        return roleService.postRole(role);
    }

    @GetMapping("/getAll")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/put/{role_id}")
    public Role putRoleById(@PathVariable int role_id, @RequestBody Role newRole) {
        return roleService.putRoleById(role_id, newRole);
    }

    @DeleteMapping("/delete/{role_id}")
    public String deleteRoleById(@PathVariable int role_id) {
        return roleService.deleteRoleById(role_id);
    }
}