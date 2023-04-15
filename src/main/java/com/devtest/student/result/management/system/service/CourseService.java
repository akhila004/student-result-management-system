package com.devtest.student.result.management.system.service;

import com.devtest.student.result.management.system.entity.Course;
import com.devtest.student.result.management.system.entity.Student;
import com.devtest.student.result.management.system.repository.CourseRepository;
import com.devtest.student.result.management.system.repository.StudentRepository;
import com.devtest.student.result.management.system.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public void createCourse(Course course){
        course.setCourseName(course.getCourseName().toUpperCase());
        courseRepository.save(course);
    }

    public List<Course> getCourses(){
        Iterable<Course> courseIterable = courseRepository.findAll();
        List<Course> courses = new ArrayList<Course>();
        courseIterable.forEach(courses::add);
        return courses;
    }

    public List<String> getTableHeaders(){
        return Constant.courseTableHeaders;
    }
}
