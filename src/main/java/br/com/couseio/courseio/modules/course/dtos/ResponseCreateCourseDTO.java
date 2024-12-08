package br.com.couseio.courseio.modules.course.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCreateCourseDTO {
    private String name;
    private String category;
    private Boolean active;
    private String instructorId;
    private List<String> studentsIds;
}
