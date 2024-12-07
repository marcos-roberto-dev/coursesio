package br.com.couseio.courseio.modules.instructor.dtos;

import lombok.Data;

@Data
public class ResponseCreateInstructorDTO {

    private String name;

    private String email;

    private String username;

    private String register;
}
