package com.manage.dao.person;

import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.manage.pojo.Person;

public interface PersonMapper {
	/*
	 * 用户登录
	 */
	public Person VipLogin(@Param("user")String user,@Param("pass")String pass);
	
	//按用户名来查询个人信息
	public Person getUserInfoById(@Param("id")String id);

	/**
     * 分页操作，调用getUserInfo limit分页方法
     * @param map
     * @return
     */
	public List<Person> getUserInfo(@Param("start")Integer start, @Param("size")Integer size);

	/*
	 * 异步查询用户是否存在操作
	 */
	public Person checkUserIsExist(@Param("user")String user);

	/**
	 * [selectUserCount 查询用户总数]
	 * @return [description]
	 */
	public Integer selectUserCount();

	//插入用户信息
	public boolean insertPerson(Person p);
	
	//修改用户信息
	public boolean updatePerson(Person p);

	//根据用户id删除用户
	public boolean deletePersonById(@Param("id")Integer id);
}