package com.student.api.bean;

import lombok.Data;

import java.util.Map;

@Data
public class Student {
    String name;
    int age;
    String address;
    Map<String, Integer> subjects;
}
