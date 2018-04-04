package com.study.data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.study.entitys.Chapter;
import com.study.entitys.o2o.Chapter2Course;
import com.study.service.ChapterService;
@Component
public class ChapterData {
	@Autowired
	private ChapterService chapterService;
	//章节Id -> 章节对象	
	private Map<Integer,Chapter> chapterMap = new HashMap<>();
	//章节Id -> 课程Id
	private Map<Integer,Integer> chapter2Course = new HashMap<>();
	//章节Id -> 材料Id
	private Map<Integer,List<Integer>> chapter2Materials = new HashMap<>();
	public void init() {
		chapterMap.clear();
		chapter2Course.clear();
		List<Chapter> chapters = chapterService.getAllChapter();
		for(Chapter chapter : chapters) {
			chapterMap.put(chapter.getChapterId(), chapter);
			List<Integer> materialList = chapterService.getChapterMaterials(chapter.getChapterId());
			chapter2Materials.put(chapter.getChapterId(), materialList);
		}
		List<Chapter2Course> chapter2courseList = chapterService.getChpater2Course();
		for(Chapter2Course chapter2CourseInfo : chapter2courseList) {
			chapter2Course.put(chapter2CourseInfo.getChapterId(), chapter2CourseInfo.getCourseId());
		}
	}
	/**
	 * 得到id对应的chapter对象
	 * @param chapterIds
	 * @return
	 */
	public List<Chapter> getChapters(List<Integer> chapterIds) {
		List<Chapter> chapters = new LinkedList<>();
		for(Integer chapterId : chapterIds) {
			if(chapterMap.get(chapterId) != null) {
				chapters.add(chapterMap.get(chapterId));
			}
		}
		return chapters;
	}
	/**
	 * 获取本章节的材料列表
	 * @param chapterId
	 * @return
	 */
	public List<Integer> getMaterials(int chapterId){
		return chapter2Materials.get(chapterId);
	}
	private static ChapterData instance = new ChapterData();
	public static ChapterData getInstance() {
		return instance;
	}
	
}
