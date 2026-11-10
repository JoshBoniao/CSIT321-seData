package com.csit321g3.service;
import java.util.List;
import java.util.NoSuchElementException;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.csit321g3.entity.Course;
import com.csit321g3.errorhandler.NameErrorResponse;
import com.csit321g3.repository.CourseRepository;

@Service 
public class CourseService{
    @Autowired 
    CourseRepository courserepo;
    public CourseService(){

    }
    
    //Create
    public Course postCourse(Course course){
        return courserepo.save(course);
    }

    //Read
    public List<Course> getAllCourses(){
        return courserepo.findAll();
    }

    //Update
    @SuppressWarnings ("finally")
    public Course putCourse(int id, Course newCourseDetails){
        try{
            Course course = courserepo.findById(id).get();
            course.setInstructor_id(newCourseDetails.getInstructor_id());
            course.setCourse_name(newCourseDetails.getCourse_name());
            course.setCourse_id(newCourseDetails.getCourse_id());
            
        }catch(NoSuchElementException e){
            throw new NameNotFoundException("Course with id " + id + " does not exist");
        }finally{
            return courserepo.save(newCourseDetails);
        }
    }

    //Delete
    public String deleteCourse(int id){
        String msg = "";
        if(courserepo.findById(id) != null){
            courserepo.deleteById(id);
            msg = "Course with id " + id + " has been deleted successfully";
        } else {
            msg = id + "does not exist!";
        }
        return msg;
    }


    @ExceptionHandler 
    public ResponseEntity<NameErrorResponse> handleException(NameNotFoundException ex){
        NameErrorResponse error = new NameErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<NameErrorResponse>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler 
    public ResponseEntity<NameErrorResponse> handleException(Exception ex){
        NameErrorResponse error = new NameErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<NameErrorResponse>(error, HttpStatus.BAD_REQUEST);
    }
}