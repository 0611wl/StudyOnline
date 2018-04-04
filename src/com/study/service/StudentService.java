package com.study.service;


import java.util.List;

import com.study.entitys.Student;
import com.study.entitys.o2o.Student2Course;

public interface StudentService {
	public Student login(String studentId,String password);
	public List<Student> studentInfo();
	public List<Student2Course> student2Course();
}
