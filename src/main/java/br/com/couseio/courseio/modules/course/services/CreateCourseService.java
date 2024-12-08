package br.com.couseio.courseio.modules.course.services;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.couseio.courseio.modules.course.dtos.RequestCreateCourseDTO;
import br.com.couseio.courseio.modules.course.dtos.ResponseCreateCourseDTO;
import br.com.couseio.courseio.modules.course.entities.CourseEntity;
import br.com.couseio.courseio.modules.course.repositories.CourseRepository;
import br.com.couseio.courseio.modules.instructor.entities.InstructorEntity;
import br.com.couseio.courseio.modules.student.entities.StudentEntity;

@Service
public class CreateCourseService {

    private final CourseRepository courseRepository;

    public CreateCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public ResponseCreateCourseDTO execute(RequestCreateCourseDTO requestCourse) {

        var instructorEntity = InstructorEntity.builder().id(UUID.fromString(requestCourse.getInstructorId())).build();
        List<String> studentsIds = requestCourse.getStudentsIds() != null ? requestCourse.getStudentsIds()
                : Collections.emptyList();
        var courseEntityBuilder = CourseEntity.builder()
                .name(requestCourse.getName())
                .category(requestCourse.getCategory())
                .active(requestCourse.getActive())
                .instructorId(instructorEntity)
                .studentsId(studentsIds.stream()
                        .map(id -> StudentEntity.builder().id(UUID.fromString(id)).build())
                        .collect(Collectors.toList()))
                .build();

        var courseEntity = courseRepository.save(courseEntityBuilder);

        return ResponseCreateCourseDTO.builder()
                .name(courseEntity.getName())
                .category(courseEntity.getCategory())
                .active(courseEntity.getActive())
                .instructorId(courseEntity.getInstructorId().getId().toString())
                .studentsIds(courseEntity.getStudentsId().stream()
                        .map(student -> student.getId().toString())
                        .collect(Collectors.toList()))
                .build();

    }

}
