package com.deep.SpringBootAngularCrudApp.service.impl;

import com.deep.SpringBootAngularCrudApp.entity.Student;
import com.deep.SpringBootAngularCrudApp.exception.StudentNotFound;
import com.deep.SpringBootAngularCrudApp.repository.StudentRepository;
import com.deep.SpringBootAngularCrudApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student s) {
        return studentRepository.save(s);
    }

    @Override
    public String deleteStudentById(Long id) {
        studentRepository.deleteById(id);
        return "Student with the id "+id+" successfully deleted";
    }

    @Override
    public Student updateStudentById(Long id, Student s) {
        Student st=studentRepository.findById(id).orElseThrow(()->new StudentNotFound("Student","Id",id));
        st.setStudentCollege(s.getStudentCollege());
        st.setStudentName(s.getStudentName());
        st.setStudentPercentage(s.getStudentPercentage());
        studentRepository.save(st);

        return st;
    }

    @Override
    public Student getStudentById(Long id) {
        Student s=studentRepository.findById(id).orElseThrow(()->new StudentNotFound("Student","Id",id));
        return s;
    }
}
