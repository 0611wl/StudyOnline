package com.study.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.study.entitys.Course;
import com.study.entitys.material.Material;

public interface MaterialService {
	public int uploadMaterial(Material material,MultipartFile file,Course course,String realPath);
	public List<Integer> getMaterialChapters(int materialId);
	public List<Material> getAllMaterial();
}
