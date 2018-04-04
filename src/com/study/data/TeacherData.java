package com.study.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.study.entitys.Teacher;
import com.study.service.TeacherService;

@Component
public class TeacherData {
	@Autowired
	private TeacherService teacherService;
	private Map<String,Teacher> teacherMap = new HashMap<>(); 
	public void init() {
		teacherMap.clear();
		List<Teacher> teachers = teacherService.getAllTeachers();
		for(Teacher teacher : teachers) {
			teacherMap.put(teacher.getTeacherId(), teacher);
		}
	}
	
	public Teacher getTeacher(String teacherId) {
		return teacherMap.get(teacherId);
	}

	private static TeacherData instance = new TeacherData();
	public static TeacherData getInstance() {
		return instance;
	}
}
