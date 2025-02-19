package com.seetharam.StudentManagementSystem.controller;

import com.seetharam.StudentManagementSystem.Entity.CourseEntity;
import com.seetharam.StudentManagementSystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping
    public List<CourseEntity> findAllCourses() {
        return courseService.courseEntityList();
    }

    @GetMapping("/{courseNumber}")
    public CourseEntity findCourseDetailsByCourseNumber(@PathVariable String courseNumber) {
        if (courseNumber.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Please provide proper Course Number");
        }
        return courseService.findCourseByCourseNumber(courseNumber);
    }

    @PostMapping
    public String createNewCourse(CourseEntity course) {
        if (course == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please provide Course details");
        } else {
            return courseService.createCourseDetails(course);
        }
    }

    @GetMapping("/{semester}")
    public List<CourseEntity> findBySemester(@PathVariable String semester) {
        if (semester.equals("Spring") || semester.equals("spring") || semester.equals("Fall") || semester.equals("fall")
                || semester.equals("Summer") || semester.equals("summer")) {
            if (courseService.listCoursesBySemester(semester).isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Courses Found for the provided semester");
            } else {
                return courseService.listCoursesBySemester(semester);
            }
        }
        return null;
    }
}
