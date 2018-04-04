package com.study.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.study.entitys.Course;
import com.study.entitys.Teacher;
@Transactional
public interface TeacherService {
	public List<Teacher> getAllTeachers();
}
