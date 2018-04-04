package com.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.study.entitys.material.Material;
import com.study.entitys.o2o.Material2Chapter;
@Repository
public interface MaterialDao {
	/**
	 * 上传材料
	 * @param material
	 * @return
	 */
	public int uploadMaterial(Material material);
	/**
	 * 得到引用次材料的章节
	 * @param materialId
	 * @return
	 */
	public List<Integer> getMaterialChapters(int materialId);
	/**
	 * 获取所有材料信息
	 * @return
	 */
	public List<Material> getAllMaterial();
	public int uploadMaterial2Course(@Param("materialId") int materialId,@Param("courseId")int courseId);
	public List<Integer> lastMaterialId(@Param("materialName") String materialName,@Param("materialType") int materialType);
}
