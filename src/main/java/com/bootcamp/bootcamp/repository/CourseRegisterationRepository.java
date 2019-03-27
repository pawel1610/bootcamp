package com.bootcamp.bootcamp.repository;

import com.bootcamp.bootcamp.model.CourseRegisteration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRegisterationRepository extends JpaRepository<CourseRegisteration, Long> {
}
