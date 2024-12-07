package br.com.couseio.courseio.modules.student.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.couseio.courseio.modules.student.dtos.RequestCreateStudentDTO;
import br.com.couseio.courseio.modules.student.services.CreateStudentService;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final CreateStudentService createStudentService;

    public StudentController(CreateStudentService createStudentService) {
        this.createStudentService = createStudentService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody RequestCreateStudentDTO requestStudent) {
        try {
            var responseEntity = this.createStudentService.execute(requestStudent);
            return ResponseEntity.ok(responseEntity);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

}
