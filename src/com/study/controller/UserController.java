package com.study.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.study.data.DataCenter;
import com.study.data.TeacherData;
import com.study.entitys.Course;
import com.study.entitys.Student;
import com.study.entitys.Teacher;
import com.study.service.StudentService;
import com.study.utils.GsonUtil;

@Controller
public class UserController {
	
	@Resource
	@Autowired
	private StudentService studentService;
	@RequestMapping("androidLogin.action")
	public void androidLogin(String studentId,String password,HttpServletResponse response) throws IOException {
		Student student = studentService.login(studentId, password);
		if(student != null) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			List<Course> coursesInfo = DataCenter.getInstance().getStudentCourseList(studentId);
			List<Course> notChooseCourseInfo = DataCenter.getInstance().getNotChooseCourseList(studentId);
			List<Course> waitForCheckInfo = DataCenter.getInstance().getStudentWaitForCheckList(studentId);
			
			Map<String,Object> jsonMap = new HashMap<>();
			jsonMap.put("student", student);
			jsonMap.put("coursesInfo", coursesInfo);
			jsonMap.put("notChooseCourses", notChooseCourseInfo);
			jsonMap.put("waitForCheckInfo", waitForCheckInfo);
			out.println(GsonUtil.toJson(jsonMap));
			System.out.println(GsonUtil.toJson(jsonMap));
		}
		else {
			return;
		}
	}
	@RequestMapping("webTeacherLogin.action")
	public ModelAndView teacherLogin(String teacherId,String password,HttpServletRequest request) {
		Teacher teacher = TeacherData.getInstance().getTeacher(teacherId);
		if(teacher != null && teacher.getPassword().equals(password)) {
			ModelAndView mav = new ModelAndView("admin.jsp");
			request.getSession().setAttribute("teacher", teacher);
			return mav;
		}
		return new ModelAndView("login.jsp");
	}
	
}
