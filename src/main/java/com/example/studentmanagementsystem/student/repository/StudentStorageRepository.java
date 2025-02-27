package com.example.studentmanagementsystem.student.repository;

import com.example.studentmanagementsystem.student.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentStorageRepository extends JpaRepository<StudentEntity, Long> {
    StudentEntity findByStudentID(long studentID);
}
