package com.manage.service.person;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Person;

public interface PersonService {
	/*
	 * 用户登录
	 */
	public Person VipLogin(String user,String pass);
	
	/*
	 * 异步查询学号是否存在操作
	 */
	public boolean checkUserIsExist(String user);
	
	//按id来查询个人信息
	public Person getUserInfoById(String id);

	// public List<Person> getUserInfo();

	public Integer selectUserCount();

	public List<Person> getUserInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//插入用户信息
	public boolean insertPerson(Person p);
	
	//修改用户信息
	public boolean updatePerson(Person p);

	//根据用户id删除用户
	public boolean deletePersonById(Integer id);
}
