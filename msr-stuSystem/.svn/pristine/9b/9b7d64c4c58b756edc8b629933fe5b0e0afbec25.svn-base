package com.msr.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.msr.entity.Attendance;
import com.msr.entity.Clazz;
import com.msr.service.AttendanceService;
@RequestMapping("/admin/attendance")
@Controller
@ControllerAdvice(annotations = RestController.class)
public class AttendanceController {
	@Autowired
	private AttendanceService attendanceService;
	/**
	 * 考勤列表页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.setViewName("attendance/list");
		return model;
	}
	/**
	 * 获取考勤列表
	 * @return
	 * String studentName,Integer companyId,Integer clazzId,Date startDate,Date endDate
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public List<Attendance> getList(Integer  stuId,Integer companyId,Integer clazzId,Date startDate,Date endDate){
		//查询班级信息
		List<Attendance> attendanceList = attendanceService.attendanceList(stuId,companyId,clazzId,startDate,endDate);
		
		return attendanceList;
	}
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/update")
	@ResponseBody
	public Map<String, String> update(Attendance attendance){
		Map<String, String> ret = new HashMap<String, String>();
		if(attendance == null){
			ret.put("type", "error");
			ret.put("msg", "请填写正确的考勤信息！");
			return ret;
		}
		if(attendanceService.update(attendance) <= 0){
			ret.put("type", "error");
			ret.put("msg", "考勤编辑失败，请联系管理员！");
			return ret;
		}
		ret.put("type", "success");
		return ret;
	}
}