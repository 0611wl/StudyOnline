package com.study.service.imp;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.study.dao.MaterialDao;
import com.study.data.DataCenter;
import com.study.entitys.Course;
import com.study.entitys.material.Material;
import com.study.service.MaterialService;
@Service
@Transactional
public class MaterialServiceImp implements MaterialService {

	@Autowired
	private MaterialDao materialDao;
	
	@Override
	public List<Integer> getMaterialChapters(int materialId) {
		// TODO Auto-generated method stub
		return materialDao.getMaterialChapters(materialId);
	}
	@Override
	public List<Material> getAllMaterial() {
		// TODO Auto-generated method stub
		return materialDao.getAllMaterial();
	}
	@Override
	public int uploadMaterial(Material material, MultipartFile file, Course course,String realPath) {
		// TODO Auto-generated method stub
		try {
			int result = materialDao.uploadMaterial(material);
			if(result ==0 ) return 0;
			List<Integer> materialsId = materialDao.lastMaterialId(material.getMaterialName(),material.getMaterialType() );
			int result2 = materialDao.uploadMaterial2Course(materialsId.get(materialsId.size()-1), course.getCourseId());
			if(result2 == 0) return 0;
			int begin = realPath.lastIndexOf('/');
			int end = realPath.lastIndexOf('.');
			String copyPath = realPath.substring(0, begin+1)+ materialsId.get(materialsId.size()-1)+realPath.substring(end);
			System.out.println(realPath);
			System.out.println(copyPath);
			File copyFile = new File(copyPath);
			if(!copyFile.getParentFile().exists()) {
				if(!copyFile.getParentFile().mkdirs()) {
					return 0;
				}
			}
			DataCenter.getInstance().init();
			file.transferTo(copyFile);
			return 1;
		}catch(IOException e) {
			return 0;
		}
	}

}
