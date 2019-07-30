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
@RequestMapping("/admin/course")
@Controller
public class CourseController {
	@Autowired
	private ClazzService clazzService;
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
}
