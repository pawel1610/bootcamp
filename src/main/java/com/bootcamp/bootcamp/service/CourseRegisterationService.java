package com.bootcamp.bootcamp.service;


import com.bootcamp.bootcamp.model.CourseEdition;
import com.bootcamp.bootcamp.model.CourseRegisteration;
import com.bootcamp.bootcamp.model.User;
import com.bootcamp.bootcamp.repository.CourseRegisterationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseRegisterationService {

    @Autowired
    CourseRegisterationRepository courseRegisterationRepository;

    public void saveUserToCourse(CourseEdition courseEdition, User user) {
        CourseRegisteration courseRegisteration = new CourseRegisteration();
        courseRegisteration.setCourseEdition(courseEdition);
        courseRegisteration.setUser(user);
        courseRegisterationRepository.save(courseRegisteration);
    }
}
