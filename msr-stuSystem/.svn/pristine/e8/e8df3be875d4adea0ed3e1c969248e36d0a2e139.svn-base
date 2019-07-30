package com.msr.service;

import java.util.List;

import com.msr.entity.Company;
import com.msr.entity.CompanyExample;
import com.msr.page.Page;

public interface CompanyService {
	/**
	 * 获取指定列的集合(companyId,companyName)两列
	 */
	public  List<Company> getCompanyNameList();
	
	/**
	 * 获取企业列表
	 */
	public List<Company> companyList(Page page,Company company);
	
	/**
	 * 获取总记录数
	 * @param queryMap
	 * @return
	 */
	public int getTotal(Page page,Company company);
	/**
	 * 添加企业信息
	 * @param company
	 * @return
	 */
	public int add(Company company);

	/**
	 * 修改企业信息
	 * @param company
	 * @return
	 */
	public int edit(Company company);
	
	/**
	 * 删除企业信息
	 * @param ids
	 * @return
	 */
	public int delete(String ids);
}
