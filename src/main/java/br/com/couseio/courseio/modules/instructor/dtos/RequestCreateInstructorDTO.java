package br.com.couseio.courseio.modules.instructor.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestCreateInstructorDTO {
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
    @Length(min = 3, max = 100)
    private String password;

    @NotBlank
    @NotNull
    private String register;
}
