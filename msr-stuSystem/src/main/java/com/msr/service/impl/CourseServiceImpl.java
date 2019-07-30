package com.msr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msr.entity.Course;
import com.msr.mapper.CourseMapper;
import com.msr.page.Page;
import com.msr.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseMapper courseMapper;

	//获取课程阶段列表
	@Override
	public List<Course> getCourseLevel() {
		return courseMapper.getCourseLevel();
	}
	
	//根据阶段id获取课程主题列表
	@Override
	public List<Course> getCourseTitle(int projectId) {
		return courseMapper.getCourseTitle(projectId);
	}
	//查找所有课程
	@Override
	public List<Course> getCourseList(Integer projectId,Integer titleId){
		// TODO Auto-generated method stub
		return courseMapper.getCourseList(projectId,titleId);
	}

	@Override
	public int add(Integer id,String name,Integer time) {
		// TODO Auto-generated method stub
		System.out.print("name"+name);
		return courseMapper.addCourseCommon(id, name, time);
	}
    //修改课程
	@Override
	public int edit(Course course) {
		// TODO Auto-generated method stub
		return courseMapper.editCourse(course);
	}
     
	//删除课程信息
	@Override
	public int delete(String ids) {
		return courseMapper.delete(ids);
	}

	/*@Override
	public List<CourseTitle> getCourseNameList(String type) {
		CourseTitleExample  courseTitleExample = new CourseTitleExample();
		Criteria criteria = courseTitleExample.createCriteria();
		
		if("project".equals(type)) {
			//阶段
			criteria.andTitleLevelEqualTo(0);  //  等于0
		}else if("title".equals(type)) {
			//主题
			criteria.andTitleLevelNotEqualTo(0);// 不等于0
		}
		return courseTitleMapper.selectByExample(courseTitleExample);
	}*/
}
