package br.com.couseio.courseio.modules.instructor.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.couseio.courseio.modules.instructor.dtos.RequestCreateInstructorDTO;
import br.com.couseio.courseio.modules.instructor.dtos.ResponseCreateInstructorDTO;
import br.com.couseio.courseio.modules.instructor.entities.InstructorEntity;
import br.com.couseio.courseio.modules.instructor.repositories.InstructorRepository;

@Service
public class CreateInstructorService {
    private final InstructorRepository instructorRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateInstructorService(InstructorRepository instructorRepository, PasswordEncoder passwordEncoder) {
        this.instructorRepository = instructorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseCreateInstructorDTO execute(RequestCreateInstructorDTO requestCreateInstructor) {
        InstructorEntity instructor = InstructorEntity.builder()
                .name(requestCreateInstructor.getName())
                .email(requestCreateInstructor.getEmail())
                .username(requestCreateInstructor.getUsername())
                .password(passwordEncoder.encode(requestCreateInstructor.getPassword()))
                .register(requestCreateInstructor.getRegister())
                .build();

        instructorRepository.save(instructor);

        return ResponseCreateInstructorDTO.builder()
                .name(instructor.getName())
                .email(instructor.getEmail())
                .username(instructor.getUsername())
                .register(instructor.getRegister())
                .build();
    }
}
