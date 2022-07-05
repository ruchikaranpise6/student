package com.student.api.controller;

import com.student.api.bean.Student;
import com.student.api.exception.StudentNotFoundException;
import com.student.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;

@RestController("/studentDetails")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getData")
    ResponseEntity<Student> getStudent(@RequestParam @NotEmpty String name) throws StudentNotFoundException {
        return ResponseEntity.ok(this.studentService.getStudentDetails(name));
    }

    @PostMapping
    ResponseEntity<Student> createStudent(@RequestBody @NotEmpty Student student) throws StudentNotFoundException {
        return ResponseEntity.ok(this.studentService.createStudent(student));
    }
}
