package br.com.couseio.courseio.modules.course.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.couseio.courseio.modules.course.dtos.RequestCreateCourseDTO;
import br.com.couseio.courseio.modules.course.services.CreateCourseService;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CreateCourseService createCourseService;

    public CourseController(CreateCourseService createCourseService) {
        this.createCourseService = createCourseService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody RequestCreateCourseDTO requestCourse) {

        try {
            var response = this.createCourseService.execute(requestCourse);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }

    }
}
