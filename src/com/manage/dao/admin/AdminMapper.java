package com.manage.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Admin;

public interface AdminMapper {
	/*
	 * �û���¼
	 */
	public Admin adminLogin(@Param("user")String user,@Param("pass")String pass);
	
	public List<Admin> getAdminList(@Param("start")Integer start,@Param("size")Integer size);
	
	//�����û���Ϣ
	public boolean insertAdmin(Admin p);
	
	//�޸��û���Ϣ
	public boolean updateAdmin(Admin p);

	//�����û�idɾ���û�
	public boolean deleteAdminById(@Param("id")Integer id);

	//�����û�id��ȡ�û���Ϣ
	public Admin getAdminInfoById(@Param("id")Integer id);
}
