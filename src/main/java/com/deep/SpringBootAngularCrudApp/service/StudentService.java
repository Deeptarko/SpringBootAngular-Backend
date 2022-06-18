package com.deep.SpringBootAngularCrudApp.service;

import com.deep.SpringBootAngularCrudApp.entity.Student;
import com.deep.SpringBootAngularCrudApp.payload.DeleteResponse;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student s);
    DeleteResponse deleteStudentById(Long id);
    Student updateStudentById(Long id,Student s);
    Student getStudentById(Long id);
}
