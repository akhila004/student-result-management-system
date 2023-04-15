package com.devtest.student.result.management.system.repository;

import com.devtest.student.result.management.system.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Integer> {
}
