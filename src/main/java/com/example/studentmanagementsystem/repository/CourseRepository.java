package com.example.studentmanagementsystem.repository;

import com.example.studentmanagementsystem.Entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity,String> {

}
