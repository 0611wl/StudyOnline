package com.study.data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.study.entitys.Student;
import com.study.entitys.o2o.Student2Course;
import com.study.service.StudentService;

@Component
public class StudentData {
	
	@Autowired(required=false)
	private StudentService studentService;
	//学生id -> 学生对象
	private Map<String,Student> studentMap = new HashMap<>();
	//学生id -> 学生所选课程
	private Map<String,List<Student2Course>> student2CourseMap = new HashMap<>();
	public void init() {
		studentMap.clear();
		student2CourseMap.clear();
		List<Student> students = studentService.studentInfo();
		if(students != null && students.size()!=0) {
			for(Student student : students) {
				studentMap.put(student.getStudentId(), student);
			}
		}
		List<Student2Course> student2CourseList = studentService.student2Course();
		if(student2CourseList != null && student2CourseList.size() > 0) {
			for(Student2Course student2Course : student2CourseList) {
				put2Map(student2Course.getStudentId(),student2Course);
			}
		}
	}
	public void put2Map(String key,Student2Course value) {
		if(student2CourseMap.get(key) == null) {
			List<Student2Course> courseList = new LinkedList<>();
			courseList.add(value);
			student2CourseMap.put(key, courseList);
		}
		else {
			student2CourseMap.get(key).add(value);
		}
	}
	/**
	 * 获取已选择课程Id列表
	 * @param studentId
	 * @return
	 */
	public List<Integer> getCourses(String studentId){
		List<Integer> courseIdList = new LinkedList<>();
		List<Student2Course> student2Courses = student2CourseMap.get(studentId);
		for(Student2Course student2Course : student2Courses) {
			if(student2Course.getState() == 1) {
				courseIdList.add(student2Course.getCourseId());
			}
		}
		return courseIdList;
	}
	/**
	 * 获取列表中状态为1的学生
	 * @param students
	 * @return
	 */
	public List<Student> getStudentsInfo(List<Student2Course> students){
		List<Student> studentsInfo = new LinkedList<>();
		for(Student2Course s2c : students) {
			if(s2c.getState() == 1) {
				Student studentInfo = studentMap.get(s2c.getStudentId());
				if(studentInfo!=null) {
					studentsInfo.add(studentInfo);
				}
			}
		}
		return studentsInfo;
	}
	/**
	 * 获取状态为0的学生
	 * @param students
	 * @return
	 */
	public List<Student> waitForCheckStudents(List<Student2Course> students){
		List<Student> studentsInfo = new LinkedList<>();
		for(Student2Course s2c : students) {
			if(s2c.getState() == 0) {
				Student studentInfo = studentMap.get(s2c.getStudentId());
				if(studentInfo!=null) {
					studentsInfo.add(studentInfo);
				}
			}
		}
		return studentsInfo;
	}
	
	
	private static StudentData instance = new StudentData();
	public static StudentData getInstance() {
		return instance;
	}
	
}
