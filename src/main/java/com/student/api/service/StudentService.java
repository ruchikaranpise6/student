package com.student.api.service;

import com.student.api.bean.Student;
import com.student.api.exception.StudentNotFoundException;

public interface StudentService {
    Student getStudentDetails(String name) throws StudentNotFoundException;

    Student createStudent(Student student);
}
