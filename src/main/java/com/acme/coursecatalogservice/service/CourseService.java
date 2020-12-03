package com.acme.coursecatalogservice.service;

import com.acme.coursecatalogservice.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses(String name);
    //Course name is optional
    Course getCourseById(Long courseId);
    Course createCourse(Course course);
    Course updateCourse(Long courseId, Course courseDetails);
    ResponseEntity<?> deleteCourse(Long courseId);
}
