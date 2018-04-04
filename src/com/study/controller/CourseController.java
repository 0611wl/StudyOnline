package com.study.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.study.data.DataCenter;
import com.study.entitys.Chapter;
import com.study.utils.GsonUtil;

public class CourseController {
	public void getCourseChapters(Integer courseId,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		List<Chapter> chapters = DataCenter.getInstance().getCourseChapters(courseId);
		out.println(GsonUtil.toJson(chapters));
	}
}
