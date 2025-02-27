package com.example.studentmanagementsystem.student.dto.responsedto;

public class StudentResponseDTO {
    private Long studentID;
    private String FirstName;
    private String Email;
    private String LastName;
    private Long PhoneNumber;

    public StudentResponseDTO(Long studentID,String firstName, String lastName, String email, Long phoneNumber){
        this.studentID = studentID;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Email = email;
        this.PhoneNumber = phoneNumber;
    }
    public StudentResponseDTO(String firstName, String lastName){
        this.FirstName = firstName;
        this.LastName = lastName;
    }
    public StudentResponseDTO(String email){
        this.Email = email;
    }
    public StudentResponseDTO(Long phoneNumber){
        this.PhoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getEmail() {
        return Email;
    }

    public String getLastName() {
        return LastName;
    }

    public Long getPhoneNumber() {
        return PhoneNumber;
    }

    public Long getStudentID() {
        return studentID;
    }
}
