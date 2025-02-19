package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.Entity.CourseEntity;
import com.example.studentmanagementsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public String createCourseDetails(CourseEntity course){
        courseRepository.save(course);
        return "Course Created Successfully!";
    }

    public List<CourseEntity> courseEntityList(){
        return courseRepository.findAll();
    }

    public CourseEntity findCourseByCourseNumber(String CourseNumber){
        List<CourseEntity> courseEntityList = courseRepository.findAll();
        for (CourseEntity course: courseEntityList){
            if (course.getCourseNumber().equals(CourseNumber)){
                return course;
            }
        }
        return null;
    }

    public List<CourseEntity> listCoursesBySemester(String Semester){
        List<CourseEntity> courseEntityList = courseRepository.findAll();
        ArrayList<CourseEntity> filterdList = new ArrayList<>();
        for (CourseEntity course: courseEntityList){
            if (course.getSemester().equals(Semester)){
                filterdList.add(course);
            }
        }
        return filterdList;
    }
}
