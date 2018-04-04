package com.study.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dao.StudentDao;
import com.study.entitys.Student;
import com.study.entitys.o2o.Student2Course;
import com.study.service.StudentService;
@Service
public class StudentServiceImp implements StudentService{
	@Autowired
	private StudentDao studentDao;
	@Override
	public Student login(String studentId,String password) {
		// TODO Auto-generated method stub
		return studentDao.login(studentId,password);
	}
	@Override
	public List<Student2Course> student2Course() {
		// TODO Auto-generated method stub
		return studentDao.student2Course();
	}
	public List<Student> studentInfo(){
		return studentDao.studentInfo();
	}
	public StudentDao getStudentDao() {
		return studentDao;
	}
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
}
