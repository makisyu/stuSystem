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

import com.msr.entity.Teacher;
import com.msr.page.Page;
import com.msr.service.TeacherService;
@RequestMapping("/admin/teacher")
@Controller
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	/**
	 * 老师列表页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.setViewName("teacher/list");
		return model;
	}
	/**
	 * 获取老师列表
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getList(Page page,Teacher teacher){
		//定义map集合，封装数据，传递给前端页面
		Map<String, Object> ret = new HashMap<String, Object>();
		
		//查询老师信息
		List<Teacher> teacherList = teacherService.teacherList(page,teacher);
		
		//往map中添加元素
		ret.put("rows", teacherList);
		ret.put("total", teacherService.getTotal(page,teacher));
		return ret;
	}
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> add(Teacher teacher){
		Map<String, String> ret = new HashMap<String, String>();
		if(teacher == null){
			ret.put("type", "error");
			ret.put("msg", "请填写正确的老师信息！");
			return ret;
		}
		if(teacherService.add(teacher) <= 0){
			ret.put("type", "error");
			ret.put("msg", "老师添加失败，请联系管理员！");
			return ret;
		}
		ret.put("type", "success");
		return ret;
	}
	
	/**
	 * 编辑老师 
	 * @param teacher
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> edit(Teacher teacher){
		Map<String, String> ret = new HashMap<String, String>();
		if(teacher == null){
			ret.put("type", "error");
			ret.put("msg", "请填写正确的老师信息！");
			return ret;
		}
		if(teacherService.edit(teacher) <= 0){
			ret.put("type", "error");
			ret.put("msg", "老师修改失败，请联系管理员！");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "老师修改成功！");
		return ret;
	}
	
	/**
	 * 批量删除用户
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
		if(teacherService.delete(ids) <= 0){
			ret.put("type", "error");
			ret.put("msg", "老师删除失败，请联系管理员！");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "用户删除成功！");
		return ret;
	}
	/**
	 * 获取"老师名称"下拉列表数据
	 */
	@RequestMapping(value="/getTeacherNameList",method=RequestMethod.POST)
	@ResponseBody
	public List<Teacher> getteacherNameList(){
		return teacherService.getTeacherNameList();
	}
}
