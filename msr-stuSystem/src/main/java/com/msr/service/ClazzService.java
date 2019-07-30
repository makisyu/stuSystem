package com.msr.service;

import java.util.List;

import com.msr.entity.Clazz;
import com.msr.entity.Clazz;
import com.msr.page.Page;

public interface ClazzService {

	/**
	 * 获取班级列表
	 */
	public List<Clazz> clazzList(Page page,Clazz clazz);
	
	/**
	 * 获取总记录数
	 * @param queryMap
	 * @return
	 */
	public int getTotal(Page page,Clazz clazz);
	

	/**
	 * 获取指定列的集合(clazzId,clazzName)两列
	 */
	public  List<Clazz> getClazzNameList();
	
	
	/**
	 * 获取总记录数
	 * @param queryMap
	 * @return
	 */
	public int add(Clazz clazz);

	/**
	 * 修改班级信息
	 * @param Clazz
	 * @return
	 */
	public int edit(Clazz clazz);
	
	/**
	 * 删除班级信息
	 * @param ids
	 * @return
	 */
	public int delete(String ids);

}
