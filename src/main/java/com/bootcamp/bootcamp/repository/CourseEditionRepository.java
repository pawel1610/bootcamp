package com.bootcamp.bootcamp.repository;

import com.bootcamp.bootcamp.model.CourseEdition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CourseEditionRepository extends JpaRepository<CourseEdition, Long> {
}
