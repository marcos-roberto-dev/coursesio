package br.com.couseio.courseio.modules.instructor.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.couseio.courseio.modules.instructor.dtos.RequestCreateInstructorDTO;
import br.com.couseio.courseio.modules.instructor.services.CreateInstructorService;

@RestController
@RequestMapping("/api/v1/instructor")
public class InstructorController {
    private final CreateInstructorService createInstructorService;

    public InstructorController(CreateInstructorService createInstructorService) {
        this.createInstructorService = createInstructorService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody RequestCreateInstructorDTO requestInstructor) {
        try {
            var responseEntity = this.createInstructorService.execute(requestInstructor);
            return ResponseEntity.ok(responseEntity);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}