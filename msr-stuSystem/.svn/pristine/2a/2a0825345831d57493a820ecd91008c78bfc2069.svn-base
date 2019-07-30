package com.msr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msr.entity.Statistical;
import com.msr.mapper.StatisticalMapper;
import com.msr.service.StatisticalService;
@Service
public class StatisticalServiceImpl implements StatisticalService {
	@Autowired
	private StatisticalMapper statisticalMapper;
	
	//统计班级人数
	@Override
	public List<Statistical> clazzCounts() {
		// TODO Auto-generated method stub
		return statisticalMapper.clazzCounts();
	}

	//按年份统计人数
	@Override
	public List<Statistical> yearCounts() {
		return statisticalMapper.yearCounts();
	}

	
	//按年份和企业统计人数
	@Override
	public List<Statistical> CompanyCounts() {
		// TODO Auto-generated method stub
		return statisticalMapper.CompanyCounts();
	}

}
