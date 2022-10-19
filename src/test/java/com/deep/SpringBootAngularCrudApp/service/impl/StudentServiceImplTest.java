package com.deep.SpringBootAngularCrudApp.service.impl;

import com.deep.SpringBootAngularCrudApp.entity.Student;
import com.deep.SpringBootAngularCrudApp.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceImplTest {

   private StudentRepository studentRepository= Mockito.mock(StudentRepository.class);

   @Test
   @DisplayName("Should Find Student By Id")
   public void getStudentById(){
        StudentServiceImpl studentService=new StudentServiceImpl(studentRepository);
        Student student=new Student(1L,"Deep","UEM",56.01);
        Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        Student newStudent=studentService.getStudentById(1L);
        assertEquals(newStudent.getStudentId(),student.getStudentId());
   }
}