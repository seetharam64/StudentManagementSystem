package com.seetharam.StudentManagementSystem.controller;

import com.seetharam.StudentManagementSystem.Entity.StudentEntity;
import com.seetharam.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentEntity> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentID}")
    public StudentEntity findStudentByID(@PathVariable Long studentID) {
        return studentService.findByStudentID(studentID);
    }

    @PostMapping
    public StudentEntity createStudent(@RequestBody StudentEntity student) {
        student.setStudentID(studentService.generateStudentID());
        return studentService.addStudent(student);
    }
}
