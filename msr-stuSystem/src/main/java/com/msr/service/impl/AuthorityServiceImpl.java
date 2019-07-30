package com.msr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msr.entity.Authority;
import com.msr.mapper.AuthorityMapper;
import com.msr.service.AuthorityService;
@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityMapper authorityDao;
	
	@Override
	public int add(Authority authority) {
		// TODO Auto-generated method stub
		return authorityDao.add(authority);
	}

	@Override
	public int deleteByRoleId(Long roleId) {
		// TODO Auto-generated method stub
		return authorityDao.deleteByRoleId(roleId);
	}

	@Override
	public List<Authority> findListByRoleId(Long roleId) {
		// TODO Auto-generated method stub
		return authorityDao.findListByRoleId(roleId);
	}

}
