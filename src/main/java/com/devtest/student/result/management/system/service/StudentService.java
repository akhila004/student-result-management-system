package com.devtest.student.result.management.system.service;

import com.devtest.student.result.management.system.entity.Student;
import com.devtest.student.result.management.system.repository.StudentRepository;
import com.devtest.student.result.management.system.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void createStudent(Student student){
        //student.setDateOfBirth(Sim);
        //student.setDateOfBirth(new Date(Constant.dateFormat.format(student.getDateOfBirth())));
        studentRepository.save(student);
    }

    public List<Student> getStudents(){
        Iterable<Student> studentIterable = studentRepository.findAll();
        List<Student> students = new ArrayList<Student>();
        studentIterable.forEach(students::add);
        return students;
    }

    public List<String> getTableHeaders(){
        return Constant.studentTableHeaders;
    }
}
