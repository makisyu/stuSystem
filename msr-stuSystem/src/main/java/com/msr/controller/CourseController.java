package com.msr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.msr.entity.Company;
import com.msr.entity.Course;
import com.msr.page.Page;
import com.msr.service.CourseService;

@RequestMapping("/admin/course")
@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;
	/**
	 * 显示课程页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.setViewName("course/list");
		return model;
	}
	
	/*
	 * 查找课程阶段:
	 * 		     
	 */
	@RequestMapping(value="/getCourseLevel",method=RequestMethod.POST)
	@ResponseBody
	public List<Course> getCourseLevel(){
		List<Course> courseLevelList=courseService.getCourseLevel();
		return courseLevelList;	
	}
	
	/*
	 * 查找课程主题:
	 * 		     
	 */
	@RequestMapping(value="/getCourseTitle",method=RequestMethod.POST)
	@ResponseBody
	public List<Course> getCourseTitle(int projectId){
		List<Course> courseTitleList=courseService.getCourseTitle(projectId);
		return courseTitleList;	
	}
	
	/**
	 * 获取课程表
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getCourseList(Integer projectId,Integer titleId){
		//定义map集合，封装数据，传递给前端页面
		Map<String, Object> ret = new HashMap<String, Object>();
		
		if( projectId == null && titleId == null) {
			projectId=1;
			titleId=5;
		}
		//查询班级信息
		List<Course> courseList = courseService.getCourseList(projectId,titleId);
		
		//往map中添加元素
		ret.put("rows", courseList);
		/*ret.put("total", clazzService.getTotal(page,clazz));*/
		return ret;
	}
	
	/**
	 * 添加课程
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> add(Integer id,String name,Integer time){
		
		Map<String, String> ret = new HashMap<String, String>();
		if(id == null){
			ret.put("type", "error");
			ret.put("msg", "请填写正确信息！");
			return ret;
		}
		
		if(name == null ){
			ret.put("type", "error");
			ret.put("msg", "请填写正确课程信息！");
			return ret;
		}
		
		/*if(time == null){
			ret.put("type", "error");
			ret.put("msg", "请填写正确课程时间信息！");
			return ret;
		}*/
		if(courseService.add(id,name,time) <= 0){
			ret.put("type", "error");
			ret.put("msg", "添加失败，请联系管理员！");
			return ret;
		}
		ret.put("type", "success");
		return ret;
	}
	
	/**
	 * 编辑课程 
	 * @param course
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> edit(Course course){
		Map<String, String> ret = new HashMap<String, String>();
		if(course == null){
			ret.put("type", "error");
			ret.put("msg", "请填写正确的课程信息！");
			return ret;
		}
		if(courseService.edit(course) <= 0){
			ret.put("type", "error");
			ret.put("msg", "课程修改失败，请联系管理员！");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "企业修改成功！");
		return ret;
	}
	
	/**
	 * 批量删除课程
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(String ids){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(ids)){
			ret.put("type", "error");
			ret.put("msg", "选择要删除的数据！");
			return ret;
		}
		if(ids.contains(",")){
			ids = ids.substring(0,ids.length()-1);
		}
		if(courseService.delete(ids) <= 0){
			ret.put("type", "error");
			ret.put("msg", "课程删除失败，请联系管理员！");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "课程删除成功！");
		return ret;
	}

	
}
