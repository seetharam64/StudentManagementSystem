package com.example.studentmanagementsystem.student.controller;

import com.example.studentmanagementsystem.student.entity.StudentEntity;
import com.example.studentmanagementsystem.student.dto.requestdto.StudentRequestDTO;
import com.example.studentmanagementsystem.student.dto.responsedto.StudentResponseDTO;
import com.example.studentmanagementsystem.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/retrievestudents")
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentID}")
    public StudentResponseDTO findStudentByID(@PathVariable Long studentID) {
        return studentService.findByStudentID(studentID);
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentRequestDTO student) {

        return studentService.addStudent(student);
    }

    @PutMapping("/{studentID}")
    public String updateStudentRecords(@PathVariable Long studentID,@RequestBody StudentRequestDTO student){
        return studentService.updateStudentRecords(studentID,student);
    }
}
