package com.bootcamp.bootcamp.repository;

import com.bootcamp.bootcamp.model.CourseEdition;
import com.bootcamp.bootcamp.model.CourseRegisteration;
import com.bootcamp.bootcamp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Repository
public interface CourseRegisterationRepository extends JpaRepository<CourseRegisteration, Long> {

    List<CourseRegisteration> findAllByUser(User user);
    CourseRegisteration findAllByUserAndCourseEdition(User user, CourseEdition courseEdition);
}
