package com.msr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.msr.entity.Clazz;
import com.msr.entity.ClazzExample;
import com.msr.entity.Teacher;

public interface ClazzMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    int countByExample(ClazzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    
    /**
	 * 批量删除班级信息
	 * @param ids
	 * @return
	 */
	public int delete(String ids);
	
    
    int deleteByExample(ClazzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    int deleteByPrimaryKey(Integer clazzId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    int insert(Clazz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    int insertSelective(Clazz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    List<Clazz> selectByExample(ClazzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    Clazz selectByPrimaryKey(Integer clazzId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    int updateByExampleSelective(@Param("record") Clazz record, @Param("example") ClazzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    int updateByExample(@Param("record") Clazz record, @Param("example") ClazzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    int updateByPrimaryKeySelective(Clazz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Jul 08 10:48:09 JST 2019
     */
    

    int updateByPrimaryKey(Clazz record);

    /**
	 * 根据班级ID查找老师
	 * @return
	 */
	Teacher getTeacher(int clazzId);
}