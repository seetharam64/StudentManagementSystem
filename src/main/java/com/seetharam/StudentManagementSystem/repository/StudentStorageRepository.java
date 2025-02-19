package com.seetharam.StudentManagementSystem.repository;

import com.seetharam.StudentManagementSystem.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentStorageRepository extends JpaRepository<StudentEntity, Long> {
    StudentEntity findByStudentID(long studentID);
}
