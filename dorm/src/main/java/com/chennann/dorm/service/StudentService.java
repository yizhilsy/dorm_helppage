package com.chennann.dorm.service;

import com.chennann.dorm.pojo.Student;

public interface StudentService {

    Student findStudentByIdAndDorm(Integer studentId, String dormNumber);
}
