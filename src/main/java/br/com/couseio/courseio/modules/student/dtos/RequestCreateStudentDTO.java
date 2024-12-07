package br.com.couseio.courseio.modules.student.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestCreateStudentDTO {
    @NotBlank
    @Length(min = 3, max = 50)
    private String name;

    @NotBlank
    @NotNull
    private String email;

    @NotBlank
    @Length(min = 3, max = 50)
    private String username;

    @NotBlank
    @Length(min = 3, max = 50)
    private String password;

    @NotBlank
    @NotNull
    private String register;
}