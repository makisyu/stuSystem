package com.msr.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.msr.entity.User;

/**
 * user用户dao
 * @author llq
 *
 */
@Repository
public interface UserMapper {
	public User findByUsername(String username);
	public int add(User user);
	public int edit(User user);
	public int editPassword(User user);
	public int delete(String ids);
	public List<User> findList(Map<String, Object> queryMap);
	public int getTotal(Map<String, Object> queryMap);
	public int saveMac(User user);
}
