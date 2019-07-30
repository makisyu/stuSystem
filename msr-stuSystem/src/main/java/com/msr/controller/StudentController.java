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

import com.msr.entity.Student;
import com.msr.page.Page;
import com.msr.service.StudentService;

@RequestMapping("/admin/student")
@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	/**
	 * 学生列表页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.setViewName("student/list");
		return model;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getList(Page page,Student student){
		//定义map集合，封装数据，传递给前端页面
		Map<String, Object> ret = new HashMap<String, Object>();
		
		//查询企业信息
		List<Student> studentList = studentService.studentList(page,student);
		
		//往map中添加元素
		ret.put("rows", studentList);
		ret.put("total", studentService.getTotal(page,student));
		return ret;
	}
	
	/**
	 * 添加学生
	 * @param student
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> add(Student student){
		Map<String, String> ret = new HashMap<String, String>();
		if(student == null){
			ret.put("type", "error");
			ret.put("msg", "请填写正确的学生信息！");
			return ret;
		}
		if(studentService.add(student) <= 0){
			ret.put("type", "error");
			ret.put("msg", "学生添加失败，请联系管理员！");
			return ret;
		}
		ret.put("type", "success");
		return ret;
	}
	
	/**
	 * 编辑学生 
	 * @param student
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> edit(Student student){
		Map<String, String> ret = new HashMap<String, String>();
		if(student == null){
			ret.put("type", "error");
			ret.put("msg", "请填写正确的学生信息！");
			return ret;
		}
		if(studentService.edit(student) <= 0){
			ret.put("type", "error");
			ret.put("msg", "学生修改失败，请联系管理员！");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "学生修改成功！");
		return ret;
	}
	
	/**
	 * 批量删除学生
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
		if(studentService.delete(ids) <= 0){
			ret.put("type", "error");
			ret.put("msg", "学生删除失败，请联系管理员！");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "学生删除成功！");
		return ret;
	}
	
	/**
	 * 获取"学生名称"下拉列表数据
	 */
	@RequestMapping(value="/getStudentNameList",method=RequestMethod.POST)
	@ResponseBody
	public List<Student> getStudentNameList(){
		return studentService.getStudentNameList();
	}

}
