package com.study.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.study.entitys.Chapter;
import com.study.entitys.o2o.Chapter2Course;
import com.study.entitys.o2o.Material2Chapter;
public interface ChapterService {
	/**
	 * 得到所有章节
	 * @return
	 */
	public List<Chapter> getAllChapter();
	/**
	 * 得到章节所对应的课程
	 * @return
	 */
	public List<Chapter2Course> getChpater2Course();
	/**
	 * 得到此章节的材料
	 * @param chapterId
	 * @return
	 */
	public List<Integer> getChapterMaterials(int chapterId);
}
