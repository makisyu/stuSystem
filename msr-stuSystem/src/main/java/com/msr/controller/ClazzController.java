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

import com.msr.entity.Clazz;
import com.msr.page.Page;
import com.msr.service.ClazzService;
@RequestMapping("/admin/clazz")
@Controller
public class ClazzController {
	@Autowired
	private ClazzService clazzService;
	/**
	 * 班级列表页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.setViewName("clazz/list");
		return model;
	}
	/**
	 * 获取班级列表
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getList(Page page,Clazz clazz){
		//定义map集合，封装数据，传递给前端页面
		Map<String, Object> ret = new HashMap<String, Object>();
		
		//查询班级信息
		List<Clazz> clazzList = clazzService.clazzList(page,clazz);
		
		//往map中添加元素
		ret.put("rows", clazzList);
		ret.put("total", clazzService.getTotal(page,clazz));
		return ret;
	}
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/add")
	@ResponseBody
	public Map<String, String> add(Clazz clazz){
		System.out.println("============add================");
		Map<String, String> ret = new HashMap<String, String>();
		if(clazz == null){
			ret.put("type", "error");
			ret.put("msg", "请填写正确的班级信息！");
			return ret;
		}
		if(clazzService.add(clazz) <= 0){
			ret.put("type", "error");
			ret.put("msg", "班级添加失败，请联系管理员！");
			return ret;
		}
		ret.put("type", "success");
		return ret;
	}
	
	
	
	
	/**
	 * 编辑班级 
	 * @param clazz
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> edit(Clazz clazz){
		Map<String, String> ret = new HashMap<String, String>();
		if(clazz == null){
			ret.put("type", "error");
			ret.put("msg", "请填写正确的班级信息！");
			return ret;
		}
		if(clazzService.edit(clazz) <= 0){
			ret.put("type", "error");
			ret.put("msg", "班级修改失败，请联系管理员！");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "班级修改成功！");
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
		if(clazzService.delete(ids) <= 0){
			ret.put("type", "error");
			ret.put("msg", "班级删除失败，请联系管理员！");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "用户删除成功！");
		return ret;
	}
	/**
	 * 获取"班级名称"下拉列表数据
	 */
	@RequestMapping(value="/getClazzNameList",method=RequestMethod.POST)
	@ResponseBody
	public List<Clazz> summaryClazz(){
		return clazzService.getClazzNameList();
	}
}
