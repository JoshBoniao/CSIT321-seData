package com.csit321g3.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity 
@Table(name="Course")
public class Course {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer course_id;
    private Integer instructor_id;
    private String course_name;

    public Course(){}
    public Course(Integer instructor_id, String course_name, Integer course_id){
        this.instructor_id = instructor_id;
        this.course_name = course_name;
        this.course_id = course_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }
    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }
    public Integer getInstructor_id() {
        return instructor_id;
    }
    public void setInstructor_id(Integer instructor_id) {
        this.instructor_id = instructor_id;
    }
    public String getCourse_name() {
        return course_name;
    }
    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

}