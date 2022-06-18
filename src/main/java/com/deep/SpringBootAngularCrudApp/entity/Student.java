package com.deep.SpringBootAngularCrudApp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="student_tbl")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long studentId;
    private String studentName;
    private String studentCollege;
    private Double studentPercentage;

}
