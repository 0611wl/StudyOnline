package com.study.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.study.entitys.Course;
import com.study.entitys.o2o.Chapter2Course;
import com.study.entitys.o2o.Material2Course;
import com.study.entitys.o2o.Student2Course;
@Repository
public interface CourseDao {
	public List<Course> courseList();
	public List<Student2Course> course2Student();
	public List<Chapter2Course> getCourseChapters();
	public List<Material2Course> getMaterials();
}
