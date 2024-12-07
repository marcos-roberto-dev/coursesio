package br.com.couseio.courseio.modules.student.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.couseio.courseio.modules.student.dtos.RequestCreateStudentDTO;
import br.com.couseio.courseio.modules.student.dtos.ResponseCreateStudentDTO;
import br.com.couseio.courseio.modules.student.entities.StudentEntity;
import br.com.couseio.courseio.modules.student.respositories.StudentRepository;

@Service
public class CreateStudentService {
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateStudentService(StudentRepository studentRepository, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseCreateStudentDTO execute(RequestCreateStudentDTO requestStudent) {
        var student = StudentEntity.builder()
                .name(requestStudent.getName())
                .email(requestStudent.getEmail())
                .username(requestStudent.getUsername())
                .password(this.passwordEncoder.encode(requestStudent.getPassword()))
                .register(requestStudent.getRegister())
                .build();

        return ResponseCreateStudentDTO.builder()
                .name(student.getName())
                .email(student.getEmail())
                .username(student.getUsername())
                .register(student.getRegister())
                .build();
    }
}
