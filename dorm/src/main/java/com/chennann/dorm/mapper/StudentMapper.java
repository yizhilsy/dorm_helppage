package com.chennann.dorm.mapper;

import com.chennann.dorm.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {

    @Select("select * from student where studentId=#{studentId} and dormNumber=#{dormNumber}")
    Student findStudentByIdAndDorm(Integer studentId, String dormNumber);
}
