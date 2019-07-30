package com.msr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.msr.entity.Statistical;
import com.msr.entity.Student;
import com.msr.entity.StudentExample;

public interface StudentMapper {
	//批量删除
	public int delete(String ids);
	
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Wed Jul 10 13:49:28 JST 2019
     */
    int countByExample(StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Wed Jul 10 13:49:28 JST 2019
     */
    int deleteByExample(StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Wed Jul 10 13:49:28 JST 2019
     */
    int deleteByPrimaryKey(Integer stuId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Wed Jul 10 13:49:28 JST 2019
     */
    int insert(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Wed Jul 10 13:49:28 JST 2019
     */
    int insertSelective(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Wed Jul 10 13:49:28 JST 2019
     */
    List<Student> selectByExample(StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Wed Jul 10 13:49:28 JST 2019
     */
    Student selectByPrimaryKey(Integer stuId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Wed Jul 10 13:49:28 JST 2019
     */
    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Wed Jul 10 13:49:28 JST 2019
     */
    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Wed Jul 10 13:49:28 JST 2019
     */
    int updateByPrimaryKeySelective(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Wed Jul 10 13:49:28 JST 2019
     */
    int updateByPrimaryKey(Student record);
}