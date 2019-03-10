package com.bootcamp.bootcamp.service;

import com.bootcamp.bootcamp.model.Course;
import com.bootcamp.bootcamp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CourseService {

    @Autowired
    CourseRepository courseRepository;
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    public Course getCourseToEdit(long id){
        Course course = courseRepository.findById(id).get();
        return course;
    }
}
