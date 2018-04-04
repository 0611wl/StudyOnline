package com.study.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.dao.ChapterDao;
import com.study.entitys.Chapter;
import com.study.entitys.o2o.Chapter2Course;
import com.study.entitys.o2o.Material2Chapter;
import com.study.service.ChapterService;
@Service
@Transactional
public class ChapterServiceImp implements ChapterService{
	
	@Autowired
	private ChapterDao chapterDao;
	@Override
	public List<Chapter> getAllChapter() {
		// TODO Auto-generated method stub
		return chapterDao.getAllChapter();
	}
	@Override
	public List<Integer> getChapterMaterials(int chapterId) {
		// TODO Auto-generated method stub
		return chapterDao.getChapterMaterials(chapterId);
	}
	@Override
	public List<Chapter2Course> getChpater2Course() {
		// TODO Auto-generated method stub
		return chapterDao.getChpater2Course();
	}
	
}
