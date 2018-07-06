package com.manage.dao.person;

import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.manage.pojo.Person;

public interface PersonMapper {
	/*
	 * �û���¼
	 */
	public Person VipLogin(@Param("user")String user,@Param("pass")String pass);
	
	//���û�������ѯ������Ϣ
	public Person getUserInfoById(@Param("id")String id);

	/**
     * ��ҳ����������getUserInfo limit��ҳ����
     * @param map
     * @return
     */
	public List<Person> getUserInfo(@Param("start")Integer start, @Param("size")Integer size);

	/*
	 * �첽��ѯ�û��Ƿ���ڲ���
	 */
	public Person checkUserIsExist(@Param("user")String user);

	/**
	 * [selectUserCount ��ѯ�û�����]
	 * @return [description]
	 */
	public Integer selectUserCount();

	//�����û���Ϣ
	public boolean insertPerson(Person p);
	
	//�޸��û���Ϣ
	public boolean updatePerson(Person p);

	//�����û�idɾ���û�
	public boolean deletePersonById(@Param("id")Integer id);
}