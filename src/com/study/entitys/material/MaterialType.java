package com.study.entitys.material;

public enum MaterialType {
	NULL("a/"),
	DOCUMENT("application/*"),
	
	IMAGE("image/*"),
	
	VIDEO("video/*"),
	;
	String value;
	MaterialType(String value){
		this.value = value;
	}
	public static MaterialType valueOfType(String value) {
		for(MaterialType materialType : MaterialType.values()) {
			String s = value.substring(0, value.indexOf("/"))+"/*";
			if(materialType.value.equals(s)) {
				return materialType;
			}
		}
		return null;
	}
}
