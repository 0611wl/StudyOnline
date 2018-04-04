package com.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.study.entitys.Student;
import com.study.entitys.o2o.Student2Course;

@Repository
public interface StudentDao {
	public Student login(@Param("studentId") String studentId,@Param("password") String password);
	public List<Student> studentInfo();
	public List<Student2Course> student2Course();
}
