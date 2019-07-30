package com.msr.service;

import java.util.List;

import com.msr.entity.Statistical;
import com.msr.entity.Student;
import com.msr.page.Page;

public interface StudentService {
	//通过学生姓名，查询学生对象
	public Student findStudentByName(String stuName);
		
	/**
	 * 获取指定列的集合(studentId,studentName)两列
	 */
	public  List<Student> getStudentNameList();
	
	/**
	 * 获取学生列表
	 */
	public List<Student> studentList(Page page,Student student);
	
	/**
	 * 获取总记录数
	 * @param queryMap
	 * @return
	 */
	public int getTotal(Page page,Student student);
	/**
	 * 添加学生信息
	 * @param company
	 * @return
	 */
	public int add(Student student);

	/**
	 * 修改学生信息
	 * @param company
	 * @return
	 */
	public int edit(Student student);
	
	/**
	 * 删除学生信息
	 * @param ids
	 * @return
	 */
	public int delete(String ids);
	

}
