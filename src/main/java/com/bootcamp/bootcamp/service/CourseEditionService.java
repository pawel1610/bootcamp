package com.bootcamp.bootcamp.service;

import com.bootcamp.bootcamp.model.Course;
import com.bootcamp.bootcamp.model.CourseEdition;
import com.bootcamp.bootcamp.repository.CourseEditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CourseEditionService {

    @Autowired
    CourseEditionRepository courseEditionRepository;

    public List<CourseEdition> getAllCourseEdition(){
        return courseEditionRepository.findAll();
    }
    public List<CourseEdition> getAllCourseEditionSortedtByStartDate(){
        return courseEditionRepository.findAllByOrderByStartDate();
    }

    public void saveCourseEdition(CourseEdition courseEdition){//
        courseEditionRepository.save(courseEdition);
    }

    public CourseEdition getCourseEditionToEdit(long id){
        CourseEdition courseEdition = courseEditionRepository.findById(id).get();
        return courseEdition;
    }
}
