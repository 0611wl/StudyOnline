package com.study.entitys.o2o;

import java.io.Serializable;

public class Course2Teacher implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	private int courseId;
	private String teacherId;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
}
