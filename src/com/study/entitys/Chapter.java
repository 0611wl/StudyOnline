package com.study.entitys;

import java.io.Serializable;

public class Chapter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	private int chapterId;
	private String chapterName;
	private String chapterDescription;
	public int getChapterId() {
		return chapterId;
	}
	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	public String getChapterDescription() {
		return chapterDescription;
	}
	public void setChapterDescription(String chapterDescription) {
		this.chapterDescription = chapterDescription;
	}
}
