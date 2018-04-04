package com.study.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dao.CourseDao;
import com.study.entitys.Course;
import com.study.entitys.o2o.Chapter2Course;
import com.study.entitys.o2o.Material2Course;
import com.study.entitys.o2o.Student2Course;
import com.study.service.CourseService;

@Service
public class CourseServiceImp implements CourseService{
	@Autowired
	private CourseDao courseDao;
	
	@Override
	public List<Course> courseData() {
		// TODO Auto-generated method stub
		List<Course> courseList = courseDao.courseList();
		System.out.println(courseList.size());
		return courseList;
	}
	

	@Override
	public List<Student2Course> course2Student() {
		// TODO Auto-generated method stub
		return courseDao.course2Student();
	}

	@Override
	public List<Chapter2Course> getCourseChapters() {
		// TODO Auto-generated method stub
		return courseDao.getCourseChapters();
	}


	@Override
	public List<Material2Course> getMaterials() {
		// TODO Auto-generated method stub
		return courseDao.getMaterials();
	}
	
	
	
}
