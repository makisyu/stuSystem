package com.msr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msr.entity.Teacher;
import com.msr.entity.TeacherExample;
import com.msr.entity.TeacherExample.Criteria;
import com.msr.entity.User;
import com.msr.mapper.TeacherMapper;
import com.msr.mapper.UserMapper;
import com.msr.page.Page;
import com.msr.service.TeacherService;
import com.msr.util.PojoUtils;
import com.msr.util.StringUtil;

@Service
public class TeacherServiceImpl implements TeacherService{
	@Autowired
	private TeacherMapper teacherMapper;
	
	@Autowired
	private UserMapper userMapper;
	/**
	 * 设置条件查询参数
	 * @param page
	 * @param teacher
	 * @return
	 */
	public TeacherExample queryTeacherExample(Page page,Teacher teacher) {
		//设置 条件查询
		TeacherExample teacherExample = new TeacherExample();
		
		Criteria criteria = teacherExample.createCriteria();
		
		//如果对象不为空，则进行条件查询
		if(teacher!=null) {

			if(!StringUtil.isEmpty(teacher.getTeacherName()))
				criteria.andTeacherNameEqualTo(teacher.getTeacherName());
			
			if(teacher.getClazzId()!=null)
				criteria.andClazzIdEqualTo(teacher.getClazzId());
		}
		
		//设置排序字段
		teacherExample.setOrderByClause("teacher_status asc,teacher_id DESC");//注意：排序使用的是sql中的列名
		//设置分页参数
		teacherExample.setStartRow(page.getOffset());
		teacherExample.setPageSize(page.getRows());
		
		
		return teacherExample;
	}
	
	/**
	 * 获取班级列表
	 */
	@Override
	public List<Teacher> teacherList(Page page, Teacher teacher) {
		TeacherExample teacherExample = queryTeacherExample(page, teacher);
		return teacherMapper.selectByExample(teacherExample);
	}


	/**
	 * 获取总记录数
	 * @param queryMap
	 * @return
	 */
	@Override
	public int getTotal(Page page,Teacher teacher) {
		TeacherExample teacherExample = queryTeacherExample(page, teacher);
		return teacherMapper.countByExample(teacherExample);
	}

	
	/**
	 * 获取指定列的集合(teacherId,teacherName)两列
	 */
	@Override
	public List<Teacher> getTeacherNameList() {
		try {
			//获取所有段的数据集合
			List<Teacher> listAll = teacherMapper.selectByExample(null);
			//获取指定字段的数据集合
			return (List<Teacher>)PojoUtils.convertToPojoByAddAttr(listAll,"teacherId,teacherName");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 添加老师信息
	 */
	@Override
	public int add(Teacher teacher) {
		// TODO Auto-generated method stub
		teacher.setTeacherStatus(1);//设置默认状态不“1”，在职
		return teacherMapper.insert(teacher);
	}

	/**
	 * 修改老师信息
	 * @param teacher
	 * @return
	 */
	@Override
	public int edit(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherMapper.updateByPrimaryKey(teacher);
	}

	/**
	 * 删除老师信息
	 */
	@Override
	public int delete(String ids) {
		return teacherMapper.delete(ids);
	}

}
