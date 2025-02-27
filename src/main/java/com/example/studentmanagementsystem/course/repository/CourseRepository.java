package com.example.studentmanagementsystem.course.repository;

import com.example.studentmanagementsystem.course.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity,String> {

}
