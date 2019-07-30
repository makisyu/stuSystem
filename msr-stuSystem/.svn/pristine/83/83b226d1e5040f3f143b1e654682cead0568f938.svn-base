package com.msr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.msr.entity.Attendance;
import com.msr.entity.Student;
import com.msr.entity.User;
import com.msr.service.AttendanceService;
import com.msr.service.StudentService;
@RequestMapping("/admin/attendance")
@Controller
public class SignController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private AttendanceService attendanceService;
	User user;
	Student student;
	/**
	 * 签到列表页面
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/sign",method=RequestMethod.GET)
	public ModelAndView sign(ModelAndView model,HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		List<String> dateList = null;
		user = (User)request.getSession().getAttribute("admin");
		student = studentService.findStudentByName(user.getUsername());
		if(student != null) {
			//通过学生id,获取考勤时间集合
			dateList = attendanceService.findaDateBystuId(student.getStuId());
			model.addObject("dateList", dateList);
			model.setViewName("attendance/sign");
		}
		return model;
	}
	
	/**
	 * 添加考勤
	 * @param signTime
	 * @param stuId
	 * @param companyId
	 * @param clazzId
	 */
	public int addAttendance(Integer stuId,Integer companyId,Integer clazzId) {
		//Date nowDate = new Date();
		
		Attendance a = new Attendance();
		a.setStuId(stuId);
		a.setCompanyId(companyId);
		a.setClazzId(clazzId);
		//a.setaDate(nowDate);
		
		int time = a.getaDate().getHours();
		
		if(time<9) {
			a.setA1("O");a.setA2("O");a.setA3("O");a.setA4("O");
			a.setA5("O");a.setA6("O");a.setA7("O");a.setA8("O");
			a.setaType("0");
		}else if(time>8 && time<=9 ) {
			a.setA1("X");
			a.setA2("O");a.setA3("O");a.setA4("O");
			a.setA5("O");a.setA6("O");a.setA7("O");a.setA8("O");
			a.setaType("1");
		}else if(time>9 && time<=10 ) {
			a.setA1("X");
			a.setA2("X");
			a.setA3("O");a.setA4("O");a.setA5("O");
			a.setA6("O");a.setA7("O");a.setA8("O");
			a.setaType("1");
		}else if(time>10 && time<=12) {
			a.setA1("X");
			a.setA2("X");
			a.setA3("X");
			a.setA4("O");a.setA5("O");
			a.setA6("O");a.setA7("O");a.setA8("O");
			a.setaType("1");
		}else if(time>12 && time<=13) {
			a.setA1("X");
			a.setA2("X");
			a.setA3("X");
			a.setA4("X");
			a.setA5("O");a.setA6("O");a.setA7("O");a.setA8("O");
			a.setaType("1");
		}else if(time>13 && time<=14) {
			a.setA1("X");
			a.setA2("X");
			a.setA3("X");
			a.setA4("X");
			a.setA5("X");
			a.setA6("O");a.setA7("O");a.setA8("O");
			a.setaType("1");
		}else if(time>14 && time<=15) {
			a.setA1("X");
			a.setA2("X");
			a.setA3("X");
			a.setA4("X");
			a.setA5("X");
			a.setA6("X");
			a.setA7("O");a.setA8("O");
			a.setaType("1");
		}else if(time>15 && time<=16) {
			a.setA1("X");
			a.setA2("X");
			a.setA3("X");
			a.setA4("X");
			a.setA5("X");
			a.setA6("X");
			a.setA7("X");
			a.setA8("O");
			a.setaType("1");
		}else if(time>16 && time<=17) {
			a.setA1("X");
			a.setA2("X");
			a.setA3("X");
			a.setA4("X");
			a.setA5("X");
			a.setA6("X");
			a.setA7("X");
			a.setA8("X");
			a.setaType("1");
		}else {
			a.setA1("X");
			a.setA2("X");
			a.setA3("X");
			a.setA4("X");
			a.setA5("X");
			a.setA6("X");
			a.setA7("X");
			a.setA8("X");
			a.setaType("1");
		}
		
		return attendanceService.add(a);
	}
	
	/**
	 * 签到
	 * @return
	 */
	@RequestMapping(value="/addSign",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addSign(HttpServletRequest request){
		Map<String, String> ret = new HashMap<String, String>();
		if(addAttendance(student.getStuId(), student.getCompanyId(), student.getClazzId())<0){
			ret.put("type", "error");
			ret.put("msg", "签到失败，请联系管理员！");
			return ret;
		}
		ret.put("type", "success");
		return ret;
	}
	
	
}