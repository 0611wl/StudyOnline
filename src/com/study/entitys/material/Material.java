package com.study.entitys.material;

import java.io.Serializable;

public class Material implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	private int materialId;
	private int materialType;
	private String materialName;
	private String materialPath;
	private String materialFileName;
	public int getMaterialId() {
		return materialId;
	}
	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}
	public int getMaterialType() {
		return materialType;
	}
	public void setMaterialType(int materialType) {
		this.materialType = materialType;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getMaterialPath() {
		return materialPath;
	}
	public void setMaterialPath(String materialPath) {
		this.materialPath = materialPath;
	}
	public String getMaterialFileName() {
		return materialFileName;
	}
	public void setMaterialFileName(String materialFileName) {
		this.materialFileName = materialFileName;
	}
	
}
