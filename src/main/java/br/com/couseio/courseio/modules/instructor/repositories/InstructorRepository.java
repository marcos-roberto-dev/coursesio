package br.com.couseio.courseio.modules.instructor.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.couseio.courseio.modules.instructor.entities.InstructorEntity;

public interface InstructorRepository extends JpaRepository<InstructorEntity, UUID> {

}
