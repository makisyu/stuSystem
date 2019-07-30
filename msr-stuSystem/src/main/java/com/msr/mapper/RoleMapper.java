package com.msr.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.msr.entity.Role;

/**
 * 角色role dao
 * @author llq
 *
 */
@Repository
public interface RoleMapper {
	public int add(Role role);
	public int edit(Role role);
	public int delete(Long id);
	public List<Role> findList(Map<String, Object> queryMap);
	public int getTotal(Map<String, Object> queryMap);
	public Role find(Long id);
}
