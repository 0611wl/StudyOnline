package com.study.data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.study.entitys.Course;
import com.study.entitys.o2o.Chapter2Course;
import com.study.entitys.o2o.Material2Course;
import com.study.entitys.o2o.Student2Course;
import com.study.service.ChapterService;
import com.study.service.CourseService;

@Component
public class CourseData {
	
	@Autowired
	@Resource
	private CourseService courseService;
	@Autowired
	private ChapterService chapterService;
	
	//课程Id -> 课程对象
	private Map<Integer,Course> courseMap = new HashMap<>();
	//课程Id -> 学生列表
	private Map<Integer,List<Student2Course>> course2StudentMap = new HashMap<>();
	// 课程id -> 章节id列表
	private Map<Integer,List<Integer>> course2ChapterMap = new HashMap<>();
	//课程id -> 材料
	private Map<Integer,List<Integer>> course2materialMap = new HashMap<>();
	
	public void init() {
		courseMap.clear();
		course2StudentMap.clear();
		course2ChapterMap.clear();
		course2materialMap.clear();
		List<Course> courses = courseService.courseData();
		if(courses != null && courses.size()!=0) {
			for(Course course : courses) {
				courseMap.put(course.getCourseId(), course);
			}
		}
		List<Student2Course> course2StudentList = courseService.course2Student();
		if(course2StudentList != null && course2StudentList.size() > 0) {
			for(Student2Course student2Course : course2StudentList) {
				put2Map(student2Course.getCourseId(),student2Course);
			}
		}
		List<Chapter2Course> courseChapters = courseService.getCourseChapters();
		for(Chapter2Course chapterCourse : courseChapters) {
			if(course2ChapterMap.get(chapterCourse.getCourseId()) == null) {
				List<Integer> list = new LinkedList<>();
				list.add(chapterCourse.getChapterId());
				course2ChapterMap.put(chapterCourse.getCourseId(), list);
			}
			else {
				course2ChapterMap.get(chapterCourse.getCourseId()).add(chapterCourse.getChapterId());
			}
		}
		List<Material2Course> course2Materials = courseService.getMaterials();
		for(Material2Course material2course : course2Materials ) {
			if(course2materialMap.get(material2course.getCourseId()) == null) {
				List<Integer> list = new LinkedList<>();
				list.add(material2course.getMaterialId());
				course2materialMap.put(material2course.getCourseId(), list);
			}
			else {
				course2materialMap.get(material2course.getCourseId()).add(material2course.getMaterialId());
			}
		}
	}
	
	public Course getCourse(int courseId) {
		return courseMap.get(courseId);
	}
	
	/**
	 * 获取未选课程列表
	 * @param courseList
	 * @return
	 */
	public List<Course> getNotChooseInfo(List<Integer> courseList){
		List<Course> notChooseCourseInfo = new LinkedList<>();
		for(Integer i: courseMap.keySet()) {
			if(!courseList.contains(i)) {
				notChooseCourseInfo.add(courseMap.get(i));
			}
		}
		return notChooseCourseInfo;
	}
	/**
	 * 获取已选课程列表
	 * @param courseList
	 * @param studentId
	 * @param style true已通过/false待审核 
	 * @return
	 */
	public List<Course> getCourses(List<Integer> courseList,String studentId,boolean style){
		List<Course> courses = new LinkedList<>();
		for(Integer courseId : courseList) {
			List<Student2Course> student2Course = course2StudentMap.get(courseId);
			boolean bool = false;
			for(Student2Course s2c : student2Course) {
				if(s2c.getStudentId().equals(studentId)) {
					if(s2c.getState() == 1) {
						bool = true;
					}
					break;
				}
			}
			if(bool == style) {
				courses.add(courseMap.get(courseId));
			}
		}
		return courses;
	}
	/**
	 * 学生选课后添加一条消息到
	 * @param key
	 * @param value
	 */
	public void put2Map(Integer key,Student2Course value) {
		if(course2StudentMap.get(key) == null) {
			List<Student2Course> studentList = new LinkedList<>();
			studentList.add(value);
			course2StudentMap.put(key, studentList);
		}
		else {
			course2StudentMap.get(key).add(value);
		}
	}
	/**
	 * 根据课程Id获取章节Id列表
	 * @param courseId
	 * @return
	 */
	public List<Integer> getChapterIdList(int courseId) {
		return this.course2ChapterMap.get(courseId);
	}
	/**
	 * 获取已选该课程的学生
	 * @param courseId
	 * @return
	 */
	public List<Student2Course> getStudents(int courseId){
		return course2StudentMap.get(courseId);
	}
	/**
	 * 获取该课程的资料
	 * @param courseId
	 * @return
	 */
	public List<Integer> getMaterialsId(int courseId){
		return course2materialMap.get(courseId);
	}
	
	//单例
	private static CourseData instance = new CourseData();
	public static CourseData getInstance() {
		return instance;
	}
}
