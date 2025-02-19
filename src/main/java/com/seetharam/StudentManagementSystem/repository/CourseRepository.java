package com.seetharam.StudentManagementSystem.repository;

import com.seetharam.StudentManagementSystem.Entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity,String> {

}
