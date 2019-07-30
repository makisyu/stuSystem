package com.msr.service;
import java.util.List;
import com.msr.entity.Teacher;
import com.msr.page.Page;

public interface TeacherService {

	/**
	 * 获取老师列表
	 */
	public List<Teacher> teacherList(Page page,Teacher teacher);
	
	/**
	 * 获取总记录数
	 * @param queryMap
	 * @return
	 */
	public int getTotal(Page page,Teacher teacher);
	

	/**
	 * 获取指定列的集合(TeacherId,TeacherName)两列
	 */
	public  List<Teacher> getTeacherNameList();
	
	
	/**
	 * 获取总记录数
	 * @param queryMap
	 * @return
	 */
	public int add(Teacher teacher);

	/**
	 * 修改老师信息
	 * @param Teacher
	 * @return
	 */
	public int edit(Teacher teacher);
	
	/**
	 * 删除老师信息
	 * @param ids
	 * @return
	 */
	public int delete(String ids);
}
