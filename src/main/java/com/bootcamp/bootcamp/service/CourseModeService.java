package com.bootcamp.bootcamp.service;

import com.bootcamp.bootcamp.model.CourseMode;
import com.bootcamp.bootcamp.repository.CourseModeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseModeService {

    @Autowired
    CourseModeRepository courseModeRepository;

    public List<CourseMode> getAllCourseMode() {
        return courseModeRepository.findAll();
    }
}
