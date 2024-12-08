package br.com.couseio.courseio.modules.instructor.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCreateInstructorDTO {

    private UUID id;

    private String name;

    private String email;

    private String username;

    private String register;
}
