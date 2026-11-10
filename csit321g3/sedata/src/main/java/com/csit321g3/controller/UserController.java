package com.csit321g3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csit321g3.entity.User;
import com.csit321g3.service.UserService;

@RestController
@RequestMapping(method = RequestMethod.GET, path = "/api/user")
public class UserController {

    @Autowired
    UserService userv;

    public UserController() {
        // TODO Auto-generated constructor stub
    }

    @GetMapping("/printAuthor")
    public String printAuthor() {
        return "Mark Joseph Barino";
    }

    //C - Create
    @PostMapping("/postNewUser")
    public User postUser(@RequestBody User user) {
        return userv.postUser(user);
    }

    //R - Read
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userv.getAllUsers();
    }

    //U - Update
    @PutMapping("/putUserDetails")
    public User putUserDetails(@RequestParam int id, @RequestBody User newUserDetails) {
        return userv.putUserDetails(id, newUserDetails);
    }

    //D - Delete
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        return userv.deleteUser(id);
    }
}