package com.manage.service.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.admin.AdminMapper;
import com.manage.pojo.Admin;

@Service
public class AdminServiceImp implements AdminService{
	/*
	 * ʵ����DAO�����
	 */
	@Resource
	private AdminMapper am;
	
	/*
	 * ����Ա��¼
	 */
	@Override
	public Admin adminLogin(String user, String pass) {
		Admin a=am.adminLogin(user, pass);
		return a;
	}

	/**
	 * ��ȡ�����б� 
	 */
	@Override
	public List<Admin> getAdminList(Integer start, Integer size) {
		// TODO Auto-generated method stub
		List<Admin> admList=null;
		admList=am.getAdminList(start, size);
		return admList;
	}

	/**
	 * [������������Ա]
	 * @param  p [����Ա����Ϣ]
	 * @return   [�Ƿ����ɹ�]
	 */
	@Override
	public boolean insertAdmin(Admin p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(am.insertAdmin(p)){
			flag=true;
		}
		return flag;
	}
	
	/**
	 * [updateAdmin �޸Ĺ���Ա��Ϣ]
	 * @param  p [description]
	 * @return   [description]
	 */
	@Override
	public boolean updateAdmin(Admin p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(am.updateAdmin(p)){
			flag=true;
		}
		return flag;
	}

	/**
	 * [deleteAdminById ���ݹ���Աidɾ������Ա]
	 * @param  id [description]
	 * @return    [description]
	 */
	@Override
	public boolean deleteAdminById(Integer id){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(am.deleteAdminById(id)){
			flag=true;
		}
		return flag;
	}

	@Override
	public Admin getAdminInfoById(Integer id){
		// TODO Auto-generated method stub
		Admin ad = new Admin();
		ad = am.getAdminInfoById(id);
		return ad;
	}
}
