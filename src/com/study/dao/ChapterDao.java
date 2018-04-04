package com.study.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.study.entitys.Chapter;
import com.study.entitys.o2o.Chapter2Course;
import com.study.entitys.o2o.Material2Chapter;
@Repository
public interface ChapterDao {
	public List<Chapter> getAllChapter();
	public List<Chapter2Course> getChpater2Course();
	public List<Integer> getChapterMaterials(int chapterId);
}
