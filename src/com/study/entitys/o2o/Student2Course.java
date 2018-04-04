package com.study.entitys.o2o;

import java.io.Serializable;

public class Student2Course implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private String studentId;
	private int courseId;
	private int state;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
