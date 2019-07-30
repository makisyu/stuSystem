package com.msr.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.msr.entity.Authority;
import com.msr.entity.Log;

/**
 * 系统日志类dao
 * @author llq
 *
 */
@Repository
public interface LogMapper {
	public int add(Log log);
	public List<Log> findList(Map<String, Object> queryMap);
	public int getTotal(Map<String, Object> queryMap);
	public int delete(String ids);
}
