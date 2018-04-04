package com.study.service;

import java.util.List;

import com.study.entitys.Course;
import com.study.entitys.o2o.Chapter2Course;
import com.study.entitys.o2o.Material2Course;
import com.study.entitys.o2o.Student2Course;

public interface CourseService {
	public List<Course> courseData();
	public List<Student2Course> course2Student();
	public List<Chapter2Course> getCourseChapters();
	public List<Material2Course> getMaterials();
}
