package com.chennann.dorm.service.impl;

import com.chennann.dorm.mapper.StudentMapper;
import com.chennann.dorm.pojo.Student;
import com.chennann.dorm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student findStudentByIdAndDorm(Integer studentId, String dormNumber) {

        return studentMapper.findStudentByIdAndDorm(studentId, dormNumber);
    }
}
