package com.seetharam.StudentManagementSystem.service;

import com.seetharam.StudentManagementSystem.Entity.StudentEntity;
import com.seetharam.StudentManagementSystem.RandomNumberGenerator;
import com.seetharam.StudentManagementSystem.repository.StudentStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class StudentService {

    @Autowired
    private StudentStorageRepository storageRepository;
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public List<StudentEntity> getallStudents() {
        return storageRepository.findAll();
    }

    public StudentEntity findbyStudentID(Long studentID) {
        return storageRepository.findById(studentID).orElse(null);
    }

    public StudentEntity addStudent(StudentEntity student) {
        return storageRepository.save(student);
    }

    public Long generateStudentID() {
        return randomNumberGenerator.generateStudentID();
    }
}
