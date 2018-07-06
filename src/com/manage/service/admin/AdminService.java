package com.manage.service.admin;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Admin;


public interface AdminService {
	/*
	 * ����Ա��¼
	 */
	public Admin adminLogin(String user,String pass);
	
	
	//�鿴���й���Ա��Ϣ
	public List<Admin> getAdminList(@Param("start")Integer start, @Param("size")Integer size);

	//�����û���Ϣ
	public boolean insertAdmin(Admin p);

	//�޸��û���Ϣ
	public boolean updateAdmin(Admin p);

	//�����û�idɾ���û�
	public boolean deleteAdminById(Integer id);

	//�����û�id��ȡ�û���Ϣ
	public Admin getAdminInfoById(@Param("id")Integer id);
}
