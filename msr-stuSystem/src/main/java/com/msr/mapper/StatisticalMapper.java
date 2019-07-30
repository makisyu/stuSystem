package com.msr.mapper;

import java.util.List;

import com.msr.entity.Statistical;

public interface StatisticalMapper {
	//统计班级人数
	public List<Statistical> clazzCounts();
	
	//按年份统计人数
	public List<Statistical> yearCounts();
	
	//按年份和企业统计人数
	public List<Statistical> CompanyCounts();
	
}
