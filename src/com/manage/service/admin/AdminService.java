package com.manage.service.admin;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Admin;


public interface AdminService {
	/*
	 * 管理员登录
	 */
	public Admin adminLogin(String user,String pass);
	
	
	//查看所有管理员信息
	public List<Admin> getAdminList(@Param("start")Integer start, @Param("size")Integer size);

	//插入用户信息
	public boolean insertAdmin(Admin p);

	//修改用户信息
	public boolean updateAdmin(Admin p);

	//根据用户id删除用户
	public boolean deleteAdminById(Integer id);

	//根据用户id获取用户信息
	public Admin getAdminInfoById(@Param("id")Integer id);
}
