package com.shiyulu.mapper;

import com.shiyulu.pojo.Student;
import com.shiyulu.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {

    @Select("select * from student where studentId=#{studentId} and dormNumber=#{dormNumber}")
    Student findStudentByIdAndDorm(Integer studentId, String dormNumber);

    @Select("select studentUserName from student where studentNumber=#{studentNumber}")
    String getStudentUserNameByNumber(String studentNumber);

    @Select("select * from student where studentUserName=#{studentUserName}")
    Student getStudentInfo(String studentUserName);
}
