package com.devtest.student.result.management.system.service;

import com.devtest.student.result.management.system.entity.Course;
import com.devtest.student.result.management.system.entity.Result;
import com.devtest.student.result.management.system.entity.Student;
import com.devtest.student.result.management.system.repository.CourseRepository;
import com.devtest.student.result.management.system.repository.ResultRepository;
import com.devtest.student.result.management.system.repository.StudentRepository;
import com.devtest.student.result.management.system.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultService {
    @Autowired
    ResultRepository resultRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    public void createResult(Result result){

        resultRepository.save(result);
    }

    public List<Result> getResults(){
        Iterable<Result> resultIterable = resultRepository.findAll();
        List<Result> results = new ArrayList<Result>();
        resultIterable.forEach(results::add);
        return results;
    }

    public List<String> getTableHeaders(){
        return Constant.resultTableHeaders;
    }

    public List<Course> getCourses(){
        Iterable<Course> courseIterable = courseRepository.findAll();
        List<Course> courses = new ArrayList<Course>();
        courseIterable.forEach(courses::add);
        return courses;
    }

    public List<Student> getStudents(){
        Iterable<Student> studentIterable = studentRepository.findAll();
        List<Student> students = new ArrayList<Student>();
        studentIterable.forEach(students::add);
        return students;
    }
}
