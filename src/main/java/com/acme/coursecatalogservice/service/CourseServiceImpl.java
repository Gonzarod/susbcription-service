package com.acme.coursecatalogservice.service;

import com.acme.coursecatalogservice.entities.Course;
import com.acme.coursecatalogservice.repository.CourseRepository;
import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses(String name) {
        List<Course> courses;
        //Course name is optional
        if (name == null) {
            courses = this.courseRepository.findAll();
        } else {
            courses = this.courseRepository.findByNameContaining(name);
        }
        return courses;
    }


    @Override
    public Course getCourseById(Long courseId) {
        return this.courseRepository.findById(courseId).orElseThrow(()->
                new ResourceNotFoundException("Course with Id: "+courseId+" not found"));
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long courseId, Course courseDetails) {
        return courseRepository.findById(courseId).map(course -> {
            course.setName(courseDetails.getName());
            course.setDescription(courseDetails.getDescription());
            return courseRepository.save(course);
        }).orElseThrow(()-> new ResourceNotFoundException("Course with Id: "+courseId+ " not found"));
    }

    @Override
    public ResponseEntity<?> deleteCourse(Long courseId) {
        return courseRepository.findById(courseId).map(course -> {
            courseRepository.delete(course);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException("Course with Id: "+courseId+ " not found"));
    }
}
