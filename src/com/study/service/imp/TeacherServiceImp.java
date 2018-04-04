package com.study.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dao.TeacherDao;
import com.study.entitys.Course;
import com.study.entitys.Teacher;
import com.study.service.TeacherService;

@Service
public class TeacherServiceImp implements TeacherService{
	@Autowired
	private TeacherDao teacherDao;

	@Override
	public List<Teacher> getAllTeachers() {
		// TODO Auto-generated method stub
		return teacherDao.getAllTeachers();
	}	
}
