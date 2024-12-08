package br.com.couseio.courseio.modules.course.dtos;

import java.util.List;

import lombok.Data;

@Data
public class RequestCreateCourseDTO {
    private String name;
    private String category;
    private Boolean active;
    private String instructorId;
    private List<String> studentsIds;
}
