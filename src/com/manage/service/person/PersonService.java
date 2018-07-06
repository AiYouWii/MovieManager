package com.manage.service.person;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Person;

public interface PersonService {
	/*
	 * �û���¼
	 */
	public Person VipLogin(String user,String pass);
	
	/*
	 * �첽��ѯѧ���Ƿ���ڲ���
	 */
	public boolean checkUserIsExist(String user);
	
	//��id����ѯ������Ϣ
	public Person getUserInfoById(String id);

	// public List<Person> getUserInfo();

	public Integer selectUserCount();

	public List<Person> getUserInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//�����û���Ϣ
	public boolean insertPerson(Person p);
	
	//�޸��û���Ϣ
	public boolean updatePerson(Person p);

	//�����û�idɾ���û�
	public boolean deletePersonById(Integer id);
}
