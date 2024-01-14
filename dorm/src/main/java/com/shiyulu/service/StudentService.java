package com.shiyulu.service;

import com.shiyulu.pojo.Student;

public interface StudentService {

    Student findStudentByIdAndDorm(Integer studentId, String dormNumber);

    String getStudentUserNameByNumber(String studentNumber);
}
