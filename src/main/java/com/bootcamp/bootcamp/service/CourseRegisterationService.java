package com.bootcamp.bootcamp.service;

import com.bootcamp.bootcamp.model.CourseEdition;
import com.bootcamp.bootcamp.model.CourseRegisteration;
import com.bootcamp.bootcamp.model.User;
import com.bootcamp.bootcamp.repository.CourseRegisterationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseRegisterationService {

    @Autowired
    CourseRegisterationRepository courseRegisterationRepository;

    public Boolean saveUserToCourse(CourseEdition courseEdition, User user) {
        CourseRegisteration courseRegisteration = new CourseRegisteration();
        courseRegisteration.setCourseEdition(courseEdition);
        courseRegisteration.setUser(user);
        if (courseRegisterationRepository.findAllByUserAndCourseEdition(user, courseEdition) == null){
            courseRegisterationRepository.save(courseRegisteration);
            return true;
        }else {
            return false;
        }
    }

    public List<CourseRegisteration> getListOfUserCourses(User user) {
        List<CourseRegisteration> listOfUserCourses = courseRegisterationRepository.findAllByUser(user);
        return listOfUserCourses;
    }
}
