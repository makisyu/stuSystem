package com.msr.controller;
/**
 * 报表统计
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.msr.entity.Clazz;
import com.msr.entity.Company;
import com.msr.entity.CompanyExample;
import com.msr.entity.Statistical;
import com.msr.entity.CompanyExample.Criteria;
import com.msr.entity.Student;
import com.msr.page.Page;
import com.msr.service.ClazzService;
import com.msr.service.CompanyService;
import com.msr.service.StatisticalService;
import com.msr.service.StudentService;
import com.msr.util.StringUtil;

@RequestMapping("/admin/statistical")
@Controller
public class StatisticalController {
	@Autowired
	private StatisticalService statisticalService;
	
	/**
	 * 进入到班级统计页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/summaryClazz",method=RequestMethod.GET)
	public ModelAndView summaryClazz(ModelAndView model){
		model.setViewName("statistical/summaryClazz");
		return model;
	}
	/**
	 * 进入到每年人数统计页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/summaryYear",method=RequestMethod.GET)
	public ModelAndView summaryStudent(ModelAndView model){
		model.setViewName("statistical/summaryYear");
		return model;
	}
	/**
	 * 进入到企业人数统计页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/summaryCompany",method=RequestMethod.GET)
	public ModelAndView summaryCompany(ModelAndView model){
		model.setViewName("statistical/summaryCompany");
		return model;
	}
	
	/**
	 * 统计班级人数
	 * @return
	 */
	@RequestMapping(value="/summaryClazz",method=RequestMethod.POST)
	@ResponseBody
	public List<Statistical> getSummaryClazz(){
		System.out.println("===========StatisticalController---> getSummaryClazz==============");
		//查询班级信息
		List<Statistical> clazzCounts = statisticalService.clazzCounts();
		return clazzCounts;
	}
	/**
	 * 按年份统计人数
	 * @return
	 */	
	@RequestMapping(value="/summaryYear",method=RequestMethod.POST)
	@ResponseBody
	public List<Statistical> yearCounts(){
		List<Statistical> yearCounts = statisticalService.yearCounts();
		return yearCounts;
	}
	/**
	 * 按年份统计各企业人数
	 * @return
	 */	
	@RequestMapping(value="/summaryCompany",method=RequestMethod.POST)
	@ResponseBody
	public List<Statistical> companyCounts(){
		List<Statistical> companyCounts = statisticalService.CompanyCounts();
		return companyCounts;
	}
	
}
