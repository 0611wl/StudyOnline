package com.study.data;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.study.entitys.Chapter;
import com.study.entitys.Course;
import com.study.entitys.Student;
import com.study.entitys.material.Material;
import com.study.entitys.o2o.Student2Course;
@Component
public class DataCenter {
	private static DataCenter instance = new DataCenter();
	public static DataCenter getInstance() {
		return instance;
	}
	@Autowired private CourseData courseData;
	@Autowired private StudentData studentData;
	@Autowired private TeacherData teacherData;
	@Autowired private ChapterData chapterData;
	@Autowired private MaterialData materialData;
	public void init() {
		studentData.init();
		courseData.init();
		teacherData.init();
		materialData.init();
		chapterData.init();
	}
	/**
	 * 获取学生已选课程列表
	 * @param studentId
	 * @return
	 */
	public List<Course> getStudentCourseList(String studentId){
		List<Integer> courseIdList = studentData.getCourses(studentId);
		List<Course> courseList = courseData.getCourses(courseIdList, studentId, true);
		return courseList;
	}
	/**
	 * 获取学生未选课程列表
	 * @param studentId
	 * @return
	 */
	public List<Course> getNotChooseCourseList(String studentId){
		List<Integer> courseIdList = studentData.getCourses(studentId);
		List<Course> notChooseCoursesList = courseData.getNotChooseInfo(courseIdList);
		return notChooseCoursesList;
	}
	/**
	 * 获取待审核课程
	 * @param studentId
	 * @return
	 */
	public List<Course> getStudentWaitForCheckList(String studentId){
		List<Integer> courseIdList = studentData.getCourses(studentId);
		List<Course> courseList = courseData.getCourses(courseIdList, studentId, false);
		return courseList;
	}
	/**
	 * 获取课程对应的章节列表
	 * @param courseId
	 * @return
	 */
	public List<Chapter> getCourseChapters(int courseId){
		List<Integer> chapterIdList = courseData.getChapterIdList(courseId);
		List<Chapter> chapterList = chapterData.getChapters(chapterIdList);
		return chapterList;
	}
	/**
	 * 获取课程已选学生
	 * @param courseId
	 * @return
	 */
	public List<Student> getCourseStudents(int courseId){
		List<Student2Course> students = courseData.getStudents(courseId);
		List<Student> studentsInfo = studentData.getStudentsInfo(students);
		return studentsInfo;
	}
	
	public List<Student> getWaitForCheckStudent(int courseId){
		List<Student2Course> students = courseData.getStudents(courseId);
		List<Student> studentsInfo = studentData.waitForCheckStudents(students);
		return studentsInfo;
	}
	/**
	 * 获取课程所有资料
	 * @param courseId
	 * @return
	 */
	public List<Material> getMaterials(int courseId){
		List<Integer> materialIds = courseData.getMaterialsId(courseId);
		if(materialIds == null) {
			return null;
		}
		if(materialIds.size() == 0) {
			return null;
		}
		return materialData.getMaterialsById(materialIds);
	}
	/**
	 * 根据章节列表
	 * @param chapterId
	 * @return
	 */
	public List<Material> getMaterialByChapter(int chapterId){
		List<Integer> materialIdList = chapterData.getMaterials(chapterId);
		List<Material> materials = new LinkedList<>();
		for(Integer materialId : materialIdList) {
			Material material = materialData.getMaterialById(materialId);
			if(material != null) {
				materials.add(material);
			}
		}
		return materials;
	}
}
