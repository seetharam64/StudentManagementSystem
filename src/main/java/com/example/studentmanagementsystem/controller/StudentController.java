package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.Entity.StudentEntity;
import com.example.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
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
    public String createStudent(@RequestBody StudentEntity student) {
        student.setStudentID(studentService.generateStudentID());
        return studentService.addStudent(student);
    }

    @PutMapping("/{studentID}")
    public String updateStudentRecords(@PathVariable Long studentID,@RequestBody StudentEntity student){
        return studentService.updateStudentRecords(studentID,student);
    }
}
