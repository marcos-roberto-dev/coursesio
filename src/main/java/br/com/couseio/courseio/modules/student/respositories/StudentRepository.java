package br.com.couseio.courseio.modules.student.respositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.couseio.courseio.modules.student.entities.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {
}
