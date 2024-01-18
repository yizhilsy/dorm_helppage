package com.shiyulu.service;

import com.shiyulu.pojo.Student;

import java.util.List;

public interface StudentService {

    Student findStudentByIdAndDorm(Integer studentId, String dormNumber);

    String getStudentUserNameByNumber(String studentNumber);

    Student getStudentInfo(String studentUserName);


    List<Student> getStudentByDorm(String dormNumber);
}
