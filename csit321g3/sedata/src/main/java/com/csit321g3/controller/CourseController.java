package com.csit321g3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csit321g3.entity.Course;
import com.csit321g3.service.CourseService;

@RestController
@RequestMapping(path = "/course/api")
// @CrossOrigin(origins = "http://localhost:3000")
public class CourseController {

    @Autowired
    CourseService courseservice;

    public CourseController() {
    }

    // C - Create
    @PostMapping("/post")
    public Course postCourse(@RequestBody Course entity) {
        return courseservice.postCourse(entity);
    }

    // R - Read
    @GetMapping("/get")
    public List<Course> getAllCourses() {
        return courseservice.getAllCourses();
    }

    // U - Update
    @PutMapping("/put")
    public Course putCourse(@RequestParam int id, @RequestBody Course newCourseDetails) {
        return courseservice.putCourse(id, newCourseDetails);
    }

    // D - Delete
    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable int id) {
        return courseservice.deleteCourse(id);
    }
}