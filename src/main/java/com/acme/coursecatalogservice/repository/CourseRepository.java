package com.acme.coursecatalogservice.repository;

import com.acme.coursecatalogservice.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findByNameContaining(String name);
}
