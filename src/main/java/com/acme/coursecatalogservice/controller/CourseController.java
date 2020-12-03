package com.acme.coursecatalogservice.controller;

import com.acme.coursecatalogservice.entities.Course;
import com.acme.coursecatalogservice.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Course", description = "API is Ready")
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    @Operation(summary = "Get All Courses", description = "Get All Courses. Can filter by name (param optional)", tags = {"Course"}
            )
    public List<Course> getAllCourses(@RequestParam(required = false) @Parameter(description = "is Optional") String name){
        return this.courseService.getAllCourses(name);
    }

    @GetMapping("/courses/{courseId}")
    @Operation(summary = "Get Plan by Id", description = "Get Course by Id", tags = {"Course"})
    public Course getCourseById(@PathVariable Long courseId){
        return this.courseService.getCourseById(courseId);
    }

    //
    @PostMapping("/courses")
    @Operation(summary = "Post Course", description = "Create Course",
            tags = {"Course"})
    public Course createCourse(@Valid @RequestBody Course newCourse){
        return this.courseService.createCourse(newCourse);
    }

    @PutMapping("/courses/{courseId}")
    @Operation(summary = "Put Course", description = "Update Course",
            tags = {"Course"})
    public Course updateCourse(@PathVariable(name = "courseId") Long courseId,
                                       @Valid @RequestBody Course courseDetails){
        return this.courseService.updateCourse(courseId,courseDetails);
    }

    @DeleteMapping("/courses/{courseId}")
    @Operation(summary = "Delete Course", description = "Delete Course",
            tags = {"Course"})
    public ResponseEntity<?> deleteCourse(@PathVariable(name = "courseId") Long courseId){
        return courseService.deleteCourse(courseId);
    }

}
