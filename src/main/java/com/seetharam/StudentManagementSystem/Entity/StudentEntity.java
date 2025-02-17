package com.seetharam.StudentManagementSystem.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Student")
public class StudentEntity {

    @Id
    @Column(nullable = false, length = 10, unique = true)
    private long studentID;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    //@Temporal(TemporalType.DATE)
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/DD/YYYY")
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;
    @Column(nullable = false)
    private String emailAddress;
    @Column(nullable = false)
    private long phoneNumber;

    public StudentEntity() {
    }

    public StudentEntity(String FirstName, String LastName, Date DateofBirth, String EmailAddress,
                         long PhoneNumber) {
        this.firstName = FirstName;
        this.lastName = LastName;
        this.dateOfBirth = DateofBirth;
        this.emailAddress = EmailAddress;
        this.phoneNumber = PhoneNumber;
    }

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
