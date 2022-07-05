package com.student.api.service;

import com.student.api.bean.Student;
import com.student.api.entity.StudentEntity;
import com.student.api.entity.SubjectEntity;
import com.student.api.exception.StudentNotFoundException;
import com.student.api.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student getStudentDetails(String name) throws StudentNotFoundException {
        Optional<StudentEntity> data = studentRepository.findByName(name);
        data.orElseThrow(() -> new StudentNotFoundException("Student not found by this name"));
        StudentEntity studentEntity = data.get();
        Student student = new Student();
        Map<String, Integer> subjects = new HashMap<>();
        BeanUtils.copyProperties(studentEntity, student);
        Set<SubjectEntity> subjectEntities = studentEntity.getSubjects();
        for (SubjectEntity subject : subjectEntities) {
            subjects.put(subject.getName(), subject.getMarks());
        }
        student.setSubjects(subjects);
        return student;
    }

    @Override
    public Student createStudent(Student request) {
        StudentEntity entity = new StudentEntity();
        Set<SubjectEntity> subjects = new HashSet<>();
        entity.setName(request.getName());
        entity.setAge(request.getAge());
        entity.setAddress(request.getAddress());
        request.getSubjects().forEach((k, v) -> {
            subjects.add(new SubjectEntity(k, v));
        });
        entity.setSubjects(subjects);
        studentRepository.save(entity);
        return request;
    }
}
