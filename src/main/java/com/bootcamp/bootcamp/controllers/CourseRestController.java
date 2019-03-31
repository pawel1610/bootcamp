package com.bootcamp.bootcamp.controllers;

import com.bootcamp.bootcamp.model.CourseEdition;
import com.bootcamp.bootcamp.model.User;
import com.bootcamp.bootcamp.service.CourseEditionService;
import com.bootcamp.bootcamp.service.CourseRegisterationService;
import com.bootcamp.bootcamp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/client")
public class CourseRestController {

    @Autowired
    private CourseEditionService courseEditionService;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseRegisterationService courseRegisterationService;


    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ResponseEntity<List<CourseEdition>> getCourses() {
        log.info("Pobranie listy wszystkich kursó");
        List<CourseEdition> courseEditionList = courseEditionService.getAllCourseEditionSortedtByStartDate();
        return ResponseEntity.ok(courseEditionList);
    }

    @GetMapping("/getCourse/{id}")
    public ResponseEntity<CourseEdition> getCourseEdition(@PathVariable(name = "id") Long id) {
        CourseEdition courseEdition = courseEditionService.getCourseEditionToEdit(id);
        if (courseEdition != null) {
            return ResponseEntity.ok(courseEdition);
        }
        return new ResponseEntity("Brak kursu o podanym ID", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/saveUser/{id}")
    public ResponseEntity saveUserToCourseEdition(@RequestBody User user,
                                                  @PathVariable(name = "id") Long id) {

        log.info("Save user {}, and gest course by id {}", user, id);
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            return new ResponseEntity("Błąd zapisu użytkownika", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        CourseEdition courseEdition = courseEditionService.getCourseEditionToEdit(id);
        if (courseEdition != null) {
            courseRegisterationService.saveUserToCourse(courseEdition, user);
            return ResponseEntity.ok("OK");
        }

        return new ResponseEntity("Brak kursu o podanym ID", HttpStatus.NOT_FOUND);

    }


}
