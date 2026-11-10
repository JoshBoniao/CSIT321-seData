package com.csit321g3.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csit321g3.entity.User;
import com.csit321g3.repository.UserRepository;
import javax.naming.NameNotFoundException;

@Service
public class UserService {

    @Autowired
    UserRepository urepo;

    public UserService() {
    }

    //C - Create
    //method will return the user being added
    public User postUser(User user) {
        return urepo.save(user);
    }

    //R - Read
    public List<User> getAllUsers() {
        return urepo.findAll();
    }

    //U - Update
    @SuppressWarnings("finally")
    public User putUserDetails(int id, User newUserDetails) {
        User user = new User();

        try {
            //findById is a pre-defined method of the repository
            user = urepo.findById(id).get();
            user.setEmail(newUserDetails.getEmail());

        } catch (NoSuchElementException ex) {
            throw new NameNotFoundException("User " + id + " does not exist!");
        } finally {
            return urepo.save(user);
        }
    }

    //D - Delete
    public String deleteUser(int id) {
        String msg = "";
        if (urepo.findById(id) != null) {
            urepo.deleteById(id);
            msg = "User " + id + " is successfully deleted!";
        } else
            msg = id + " does not exist!";
        return msg;
    }
}