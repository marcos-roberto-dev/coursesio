package br.com.couseio.courseio.modules.course.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.couseio.courseio.modules.course.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {

}
