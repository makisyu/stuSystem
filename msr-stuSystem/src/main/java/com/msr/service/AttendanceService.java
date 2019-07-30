package com.msr.service;

import java.util.Date;
import java.util.List;

import com.msr.entity.Attendance;
import com.msr.page.Page;

public interface AttendanceService {
	//获取考勤列表
	public List<Attendance> attendanceList(Integer stuId,Integer companyId,Integer clazzId,Date startDate,Date endDate);
	
	//修改考勤
	public int update(Attendance attendance);
	
	//签到生成考勤
	public int add(Attendance attendance);

	//通过学生id,获取考勤时间集合
	public List<String> findaDateBystuId(Integer stuId);
	
	
}
