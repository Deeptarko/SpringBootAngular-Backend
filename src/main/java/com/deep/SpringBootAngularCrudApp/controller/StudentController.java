package com.deep.SpringBootAngularCrudApp.controller;

import com.deep.SpringBootAngularCrudApp.entity.Student;
import com.deep.SpringBootAngularCrudApp.payload.DeleteResponse;
import com.deep.SpringBootAngularCrudApp.service.StudentService;
import com.deep.SpringBootAngularCrudApp.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/home")
    public ResponseEntity<String> homePage(){
        return ResponseEntity.ok("This is home page");
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<Student> saveStudent(@RequestBody Student s){
        Student st=studentService.saveStudent(s);
        return new ResponseEntity<>(st, HttpStatus.CREATED);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student>studentList=studentService.getAllStudents();
        return ResponseEntity.ok(studentList);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<DeleteResponse> deleteStudentById(@PathVariable("studentId") Long id){
        DeleteResponse response=studentService.deleteStudentById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudentById(@RequestBody Student s,@PathVariable("studentId") Long id){
        Student updatedStudent=studentService.updateStudentById(id,s);
        return new ResponseEntity<>(updatedStudent,HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable("studentId")Long id){
        Student s=studentService.getStudentById(id);
        return new ResponseEntity<>(s,HttpStatus.FOUND);
    }



}
