package com.study.data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.study.entitys.material.Material;
import com.study.service.MaterialService;

@Component
public class MaterialData {
	@Autowired
	private MaterialService materialService;
	// 材料Id -> 材料对象
	private Map<Integer,Material> materialMap = new HashMap<>();
	// 材料id-> 被应用章节列表
	private Map<Integer,List<Integer>> material2ChapterMap = new HashMap<>();

	public void init() {
		materialMap.clear();
		material2ChapterMap.clear();
		List<Material> materials = materialService.getAllMaterial();
		for(Material material : materials) {
			materialMap.put(material.getMaterialId(), material);
			material2ChapterMap.put(material.getMaterialId(), materialService.getMaterialChapters(material.getMaterialId()));
		}		
	}
	public List<Material> getMaterialsById(List<Integer> materialsId){
		List<Material> materials = new LinkedList<>();
		for(Integer i : materialsId) {
			materials.add(materialMap.get(i));
		}
		return materials;
	}
	public Material getMaterialById(int materialId) {
		return materialMap.get(materialId);
	}
	//单例
	private static MaterialData instance = new MaterialData();
	public static MaterialData getInstance() {
		return instance;
	}
}
