package com.study.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.study.data.CourseData;
import com.study.data.DataCenter;
import com.study.entitys.Chapter;
import com.study.entitys.Course;
import com.study.entitys.Student;
import com.study.utils.GsonUtil;

@Controller
public class ChapterController {
	/**
	 * 获取课程的所有章
	 * @param courseId
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("getCourseChapters.action")
	public void getCourseChapters(int courseId,HttpServletResponse response) throws IOException{
		if(courseId == 0) return;
		List<Chapter> chaptersInfo = DataCenter.getInstance().getCourseChapters(courseId);
		Map<String,Object> maps = new HashMap<>();
		maps.put("chaptersInfo", chaptersInfo);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println(GsonUtil.toJson(maps));
		out.println(GsonUtil.toJson(maps));
	}
	@RequestMapping("webGetCourseChapters.action")
	public ModelAndView webGetCourseChapters(int courseId,HttpSession session) {
		List<Chapter> chaptersInfo = DataCenter.getInstance().getCourseChapters(courseId);
		Course course = CourseData.getInstance().getCourse(courseId);
		ModelAndView mav = new ModelAndView("admin.jsp");
		session.setAttribute("course",course);
		mav.addObject("students", DataCenter.getInstance().getCourseStudents(courseId));
		mav.addObject("waitForCheckStudents",DataCenter.getInstance().getWaitForCheckStudent(courseId));
		if(chaptersInfo != null && chaptersInfo.size() > 0) {
			session.setAttribute("chapters",chaptersInfo);
		}
		return mav;
	}
	@RequestMapping("webChapterInfo.action")
	public ModelAndView webGetChapterInfo(int chapterId,HttpServletRequest request) {
		Course course = (Course)request.getSession().getAttribute("course");
		ModelAndView mav = new ModelAndView("chapter.jsp");
		List<Student> students = DataCenter.getInstance().getCourseStudents(course.getCourseId());
		mav.addObject("students",students);
		return mav;
	}
}
