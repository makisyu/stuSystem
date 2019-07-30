package com.msr.mapper;

import com.msr.entity.Course;
import com.msr.entity.CourseExample;


import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseMapper {
	/*
	 * 批量删除
	 */
	 public int delete(String ids);
	 
	 //获取阶段列表
	 public List<Course> getCourseLevel();
	 
	//根据阶段或许课程主题列表
	 public List<Course> getCourseTitle(int projectId);
	
	 //获取所有课程
	 public List<Course> getCourseList(@Param("projectId")Integer projectId,@Param("titleId")Integer titleId);
	 
	 //添加课程common
	 public int addCourseCommon(@Param("id")Integer id,@Param("name")String name,@Param("time")Integer time);
	 
	 //修改课程
	 public int editCourse( Course course);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Mon Jul 22 12:17:20 JST 2019
     */
    int countByExample(CourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Mon Jul 22 12:17:20 JST 2019
     */
    int deleteByExample(CourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Mon Jul 22 12:17:20 JST 2019
     */
    int deleteByPrimaryKey(Integer courseId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Mon Jul 22 12:17:20 JST 2019
     */
    int insert(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Mon Jul 22 12:17:20 JST 2019
     */
    int insertSelective(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Mon Jul 22 12:17:20 JST 2019
     */
    List<Course> selectByExample(CourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Mon Jul 22 12:17:20 JST 2019
     */
    Course selectByPrimaryKey(Integer courseId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Mon Jul 22 12:17:20 JST 2019
     */
    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Mon Jul 22 12:17:20 JST 2019
     */
    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Mon Jul 22 12:17:20 JST 2019
     */
    int updateByPrimaryKeySelective(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Mon Jul 22 12:17:20 JST 2019
     */
    int updateByPrimaryKey(Course record);

	


}