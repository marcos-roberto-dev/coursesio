package br.com.couseio.courseio.modules.student.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.couseio.courseio.modules.student.dtos.RequestCreateStudent;
import br.com.couseio.courseio.modules.student.entities.StudentEntity;
import br.com.couseio.courseio.modules.student.respositories.StudentRepository;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public StudentController(StudentRepository studentRepository, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody RequestCreateStudent entity) {

        try {
            var student = StudentEntity.builder()
                    .name(entity.getName())
                    .email(entity.getEmail())
                    .username(entity.getUsername())
                    .password(this.passwordEncoder.encode(entity.getPassword()))
                    .register(entity.getRegister())
                    .build();

            this.studentRepository.save(student);

            return ResponseEntity.ok("Student created");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

}
