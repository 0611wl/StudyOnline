package com.study.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.study.data.DataCenter;
import com.study.entitys.Course;
import com.study.entitys.material.Material;
import com.study.entitys.material.MaterialType;
import com.study.service.MaterialService;
import com.study.utils.GsonUtil;
@Controller
public class MaterialController {
	@Autowired
	private MaterialService materialService;
	/**
	 * 文件上传
	 * @param request
	 * @param file
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("upload.action")
	public ModelAndView uploadDocument(HttpServletRequest request,MultipartFile file) throws IllegalStateException,IOException{
		ModelAndView mav = new ModelAndView("redirect:/materials.action");
		if(file.isEmpty()) {
			mav.addObject("msg","上传失败");
			return mav;
		}
		Course course  = (Course)request.getSession().getAttribute("course");
		Material material = new Material();
		material.setMaterialName(file.getOriginalFilename());
		String multipartFile = file.getContentType();
		MaterialType materialType = MaterialType.valueOfType(multipartFile);
		if(materialType != null) {
			material.setMaterialType(materialType.ordinal());			
		}
		material.setMaterialPath(request.getContextPath()+"/material/"+material.getMaterialName());
		System.out.println(material.getMaterialPath());
		String realPath = request.getSession().getServletContext().getRealPath("/material/")+"/"+material.getMaterialName();
		System.out.println(realPath);
		int result = materialService.uploadMaterial(material, file, course,realPath);
		if(result == 0) {
			mav.addObject("msg","上传失败");
			System.out.println("上传失败");
		}
		else {
			mav.addObject("msg","上传成功");
			System.out.println("上传成功");
		}
		return mav;
	}
	@RequestMapping("materials.action")
	public ModelAndView getMaterialByCourse(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Course course = (Course) session.getAttribute("course");
		
		List<Material> materials = DataCenter.getInstance().getMaterials(course.getCourseId());
		ModelAndView mav = new ModelAndView("materials.jsp");
		
		mav.addObject("materials",materials);
		return mav;
	}
	@RequestMapping("chapterMaterials.action")
	public void getMaterialByChapter(Integer chapterId,HttpServletResponse response) throws IOException{
		List<Material> material = DataCenter.getInstance().getMaterialByChapter(chapterId);
		PrintWriter out = response.getWriter();
		String gsonData = GsonUtil.toJson(material);
		out.write(gsonData);
	}
}
