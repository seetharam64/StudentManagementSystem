package com.example.studentmanagementsystem.student.service;

import com.example.studentmanagementsystem.course.service.CourseService;
import com.example.studentmanagementsystem.student.entity.StudentEntity;
import com.example.studentmanagementsystem.RandomNumberGenerator;
import com.example.studentmanagementsystem.course.repository.CourseRepository;
import com.example.studentmanagementsystem.student.repository.StudentStorageRepository;
import com.example.studentmanagementsystem.student.dto.requestdto.StudentRequestDTO;
import com.example.studentmanagementsystem.student.dto.responsedto.StudentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentStorageRepository storageRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseService courseService;

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();


    public Long generateStudentID() {
        return randomNumberGenerator.generateStudentID();
    }

    public List<StudentResponseDTO> getAllStudents() {
        return storageRepository.findAll().stream().map(studentEntity -> new StudentResponseDTO(
                studentEntity.getStudentID(),studentEntity.getFirstName(),studentEntity.getLastName()
                ,studentEntity.getEmailAddress(),studentEntity.getPhoneNumber())).toList();
    }

    public StudentResponseDTO findByStudentID(Long studentID) {
        StudentEntity student =  storageRepository.findById(studentID).orElse(null);
        StudentResponseDTO response = new StudentResponseDTO(student.getStudentID(),student.getFirstName(),
                student.getLastName(), student.getEmailAddress(),student.getPhoneNumber());
        return response;
    }

    //accepting student details using studentRequestDTO
    public ResponseEntity<StudentResponseDTO> addStudent(StudentRequestDTO student) {
        try {
           StudentEntity updatedDetails =  addStudentDetailsIntoDatabase(student);
           StudentResponseDTO response = new StudentResponseDTO(
                   updatedDetails.getStudentID(),updatedDetails.getFirstName(),
                   updatedDetails.getLastName(),updatedDetails.getEmailAddress(), updatedDetails.getPhoneNumber());
           return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception e){
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        //responding to the student by giving his details
    }

    private StudentEntity addStudentDetailsIntoDatabase(StudentRequestDTO student){
        //creating a object for student entity
        StudentEntity studentEntity = new StudentEntity();
        //storing details provided by student into student entity.
        studentEntity.setStudentID(generateStudentID());
        studentEntity.setFirstName(student.getFirstName());
        studentEntity.setLastName(student.getLastName());
        studentEntity.setEmailAddress(student.getEmailAddress());
        studentEntity.setPhoneNumber(student.getPhoneNumber());
        studentEntity.setDateOfBirth(student.getDateOfBirth());
        //saving the student entity into database
        storageRepository.save(studentEntity);
        return studentEntity;
    }



    public String updateStudentRecords(Long studentID, StudentRequestDTO student){
        //Retrieving the student information from the database
        StudentEntity currentStudentInfo = storageRepository.findByStudentID(studentID);
        if (currentStudentInfo== null){
            throw new RuntimeException("Student with ID" + studentID + "not found.");
        }
        //checking the value passed by the student, if the field have some value then we are updating the value to the
        // student
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
        //saving the updated value to the database
        storageRepository.save(currentStudentInfo);
        return "Student Info Updated Successfully";
    }


}
