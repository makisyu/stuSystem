package com.msr.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.msr.entity.Course;
import com.msr.page.Page;

public interface CourseService {
	/**
	 * 课程阶段列表
	 */
	public List<Course> getCourseLevel();

	public List<Course> getCourseTitle(int projectId);

	public List<Course> getCourseList(Integer projectId ,Integer titleId);

	public int add(Integer id,String name,Integer time);

	public int edit(Course course);

	int delete(String ids);
	
}