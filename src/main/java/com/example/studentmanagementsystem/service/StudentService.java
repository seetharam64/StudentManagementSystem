package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.Entity.StudentEntity;
import com.example.studentmanagementsystem.RandomNumberGenerator;
import com.example.studentmanagementsystem.repository.StudentStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentStorageRepository storageRepository;
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public List<StudentEntity> getAllStudents() {
        return storageRepository.findAll();
    }

    public StudentEntity findByStudentID(Long studentID) {
        return storageRepository.findById(studentID).orElse(null);
    }

    public String addStudent(StudentEntity student) {
        storageRepository.save(student);
        return "Student details saved into database successfully!";
    }

    public Long generateStudentID() {
        return randomNumberGenerator.generateStudentID();
    }

    public String updateStudentRecords(Long studentID, StudentEntity student){
        StudentEntity currentStudentInfo = storageRepository.findByStudentID(studentID);
        if(student.getFirstName() != null){
            currentStudentInfo.setFirstName(student.getFirstName());
        }
        if(student.getLastName() != null){
            currentStudentInfo.setLastName(student.getLastName());
        }
        if(student.getEmailAddress() != null){
            currentStudentInfo.setEmailAddress(student.getEmailAddress());
        }
        if(student.getPhoneNumber() != null){
            currentStudentInfo.setPhoneNumber(student.getPhoneNumber());
        }
        if (student.getDateOfBirth() != null){
            currentStudentInfo.setDateOfBirth(student.getDateOfBirth());
        }
        storageRepository.save(currentStudentInfo);
        return "Student Info Updated Successfully";
    }


}
