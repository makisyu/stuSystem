package com.msr.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msr.entity.Attendance;
import com.msr.entity.AttendanceExample;
import com.msr.entity.AttendanceExample.Criteria;
import com.msr.mapper.AttendanceMapper;
import com.msr.service.AttendanceService;
import com.msr.util.DateUtil;
import com.msr.util.StringUtil;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
	private AttendanceMapper attendanceMapper;
	
	/**
	 * 设置条件查询参数
	 * @param page
	 * @param clazz
	 * @return
	 */
	/**
	 * 获取考勤列表
	 */
	@Override
	public List<Attendance> attendanceList(Integer stuId,Integer companyId,Integer clazzId,Date startDate,Date endDate) {
		AttendanceExample attendanceExample = new AttendanceExample();
		
		
		Criteria criteria = attendanceExample.createCriteria();
		//如果对象不为空，则进行条件查询
		if(!StringUtil.isEmpty(stuId) && stuId!=-1) {//stuId不为空
			
			criteria.andStuIdEqualTo(stuId);
		}
		if(!StringUtil.isEmpty(companyId)) {//companyId不为空
			criteria.andCompanyIdEqualTo(companyId);
		}
		if(!StringUtil.isEmpty(clazzId)) {//clazzId不为空
			criteria.andClazzIdEqualTo(clazzId);
		}
		if(!StringUtil.isEmpty(startDate) && !StringUtil.isEmpty(endDate)) {//startDate和endDate,按时间范围查找
			criteria.andADateBetween(startDate, endDate);
		}
		
		attendanceExample.setOrderByClause("a_date DESC");
		
		return attendanceMapper.selectByExample(attendanceExample);
	}

	//修改考勤
	@Override
	public int update(Attendance attendance) {
		if(StringUtil.isEmpty(attendance.getA1())) {
			attendance.setA1("X");
		}
		if(StringUtil.isEmpty(attendance.getA2())) {
			attendance.setA2("X");
		}
		if(StringUtil.isEmpty(attendance.getA3())) {
			attendance.setA3("X");
		}
		if(StringUtil.isEmpty(attendance.getA4())) {
			attendance.setA4("X");
		}
		if(StringUtil.isEmpty(attendance.getA5())) {
			attendance.setA5("X");
		}
		if(StringUtil.isEmpty(attendance.getA6())) {
			attendance.setA6("X");
		}
		if(StringUtil.isEmpty(attendance.getA7())) {
			attendance.setA7("X");
		}
		if(StringUtil.isEmpty(attendance.getA8())) {
			attendance.setA8("X");
		}
		
		if(attendance.equals("1")) {
			attendance.setaType("迟到");
		}
		if(attendance.equals("2")) {
			attendance.setaType("旷课");
		}
		if(attendance.equals("3")) {
			attendance.setaType("早退");
		}
		if(attendance.equals("4")) {
			attendance.setaType("病假");
		}
		if(attendance.equals("5")) {
			attendance.setaType("事假");
		}
		return attendanceMapper.updateByPrimaryKey(attendance);
	}

	//签到生成考勤
	@Override
	public int add(Attendance attendance) {
		// TODO Auto-generated method stub
		return attendanceMapper.insert(attendance);
	}

	//通过学生id,获取考勤时间集合
	@Override
	public List<String> findaDateBystuId(Integer stuId) {
		List<String> dateList = new ArrayList<String>();
		// TODO Auto-generated method stub
		AttendanceExample attendanceExample = new AttendanceExample();
		Criteria createCriteria = attendanceExample.createCriteria();
		createCriteria.andStuIdEqualTo(stuId);
		
		List<Attendance> aList = attendanceMapper.selectByExample(attendanceExample);
		
		for (Attendance attendance : aList) {
			String date = DateUtil.getDateTimestamp(attendance.getaDate())+"";
			dateList.add(date.substring(0,date.length()-3));
		}
		
		return dateList;
	}

}
