package br.com.couseio.courseio.modules.student.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCreateStudentDTO {

    private String name;

    private String email;

    private String username;

    private String register;
}
