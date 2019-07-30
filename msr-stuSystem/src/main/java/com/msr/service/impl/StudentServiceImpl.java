package com.msr.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msr.entity.Clazz;
import com.msr.entity.Student;
import com.msr.entity.StudentExample;
import com.msr.entity.StudentExample.Criteria;
import com.msr.mapper.ClazzMapper;
import com.msr.mapper.StudentMapper;
import com.msr.page.Page;
import com.msr.service.StudentService;
import com.msr.util.DateUtil;
import com.msr.util.PojoUtils;
import com.msr.util.StringUtil;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private ClazzMapper clazzMapper;
	
	
	/**
	 * 设置条件查询参数
	 * @param page
	 * @param company
	 * @return
	 */
    public StudentExample queryStudentExample(Page page,Student student) {
    	//设置 条件查询
    			StudentExample studentExample = new StudentExample();
    			Criteria criteria = studentExample.createCriteria();
    			
    			//如果对象不为空，则进行条件查询
    			if(student!=null) {
    				if(!StringUtil.isEmpty(student.getStuName()))
    					criteria.andStuNameEqualTo(student.getStuName());
    				if(student.getClazzId()!=null)
    					criteria.andClazzIdEqualTo(student.getClazzId());
    				if(student.getCompanyId()!=null)
    					criteria.andCompanyIdEqualTo(student.getCompanyId());
    				if(student.getTeacherId()!=null)
    					criteria.andTeacherIdEqualTo(student.getTeacherId());
 				
    			}
    			//设置排序字段
    			studentExample.setOrderByClause("stu_id DESC");//注意：排序使用的是sql中的列名
    			//设置分页参数
    			studentExample.setStartRow(page.getOffset()); 
    			studentExample.setPageSize(page.getRows());
    			
    			return studentExample;
    }
  
	
	  /**
	   * 获取学生列表
	   */
	@Override
	public List<Student> studentList(Page page, Student student) {
		StudentExample studentExample =queryStudentExample(page,student);
		return studentMapper.selectByExample(studentExample);
	}
	
	/**
	 * 获取总记录数
	 * @param queryMap
	 * @return
	 */
	@Override
	public int getTotal(Page page, Student student) {
		StudentExample studentExample =queryStudentExample(page,student);
		return studentMapper.countByExample(studentExample);
	}
	
	/**
	 * 添加学生信息
	 */
	@Override
	public int add(Student student) {
		int clazzId=student.getClazzId();
		Clazz clazz=clazzMapper.selectByPrimaryKey(clazzId);
		student.setStuBegintime(clazz.getClazzStarttime());
		student.setStuEndtime(clazz.getClazzEndtime());
		student.setTeacherId(clazz.getTeacherId());
		// TODO Auto-generated method stub
		return studentMapper.insert(student);
	}

	/**
	 * 修改学生信息
	 * @param student
	 * @return
	 */
	@Override
	public int edit(Student student) {
		/*int clazzId = student.getClazzId();
		Clazz clazz =clazzMapper.selectByPrimaryKey(clazzId);
		student.setStuBegintime(clazz.getClazzStarttime());
		student.setStuEndtime(clazz.getClazzEndtime());*/
		//日期修改
		//比较两日期大小。如果date>otherDate则返回true,否则false
				if(DateUtil.whenGT(student.getStuEndtime(),new Date())) {
					student.setStuStatus(1);
				}else {
					student.setStuStatus(2);
					}
				return studentMapper.updateByPrimaryKey(student);
			}
		// TODO Auto-generated method stub
		
    
	/**
	 * 删除学生信息
	 */
	@Override
	public int delete(String ids) {
		// TODO Auto-generated method stub
		return studentMapper.delete(ids);
	}
	
	/**
	 * 获取指定列的集合(studentId,studentName)两列
	 */
	@Override
	public List<Student> getStudentNameList() {
		try {
			//获取所有段的数据集合
			List<Student> listAll = studentMapper.selectByExample(null);
			//获取指定字段的数据集合
			return (List<Student>)PojoUtils.convertToPojoByAddAttr(listAll,"stuId,stuName");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//通过学生姓名，查询学生对象
	@Override
	public Student findStudentByName(String stuName) {

		StudentExample studentExample = new StudentExample();
		Criteria createCriteria = studentExample.createCriteria();
		createCriteria.andStuNameEqualTo(stuName);
		List<Student> stuList = studentMapper.selectByExample(studentExample);
		if(stuList!=null && stuList.size()>0) {
			return stuList.get(0);
		}
		return null;
	
	}
}
