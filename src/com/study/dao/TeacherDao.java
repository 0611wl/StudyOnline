package com.study.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.study.entitys.Course;
import com.study.entitys.Teacher;
@Repository
public interface TeacherDao {
	public List<Teacher> getAllTeachers();
	public List<Course> courses(String teacherId);
}
