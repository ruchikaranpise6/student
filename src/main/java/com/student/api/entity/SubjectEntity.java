package com.student.api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "subject")
@Data
public class SubjectEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int marks;

    @Column(name = "student_id", nullable = true)
    private String studentId;

    public SubjectEntity(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}
