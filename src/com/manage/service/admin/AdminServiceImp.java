package com.manage.service.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.admin.AdminMapper;
import com.manage.pojo.Admin;

@Service
public class AdminServiceImp implements AdminService{
	/*
	 * 实例化DAO层对象
	 */
	@Resource
	private AdminMapper am;
	
	/*
	 * 管理员登录
	 */
	@Override
	public Admin adminLogin(String user, String pass) {
		Admin a=am.adminLogin(user, pass);
		return a;
	}

	/**
	 * 获取管理列表 
	 */
	@Override
	public List<Admin> getAdminList(Integer start, Integer size) {
		// TODO Auto-generated method stub
		List<Admin> admList=null;
		admList=am.getAdminList(start, size);
		return admList;
	}

	/**
	 * [插入新增管理员]
	 * @param  p [管理员的信息]
	 * @return   [是否插入成功]
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
	 * [updateAdmin 修改管理员信息]
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
	 * [deleteAdminById 根据管理员id删除管理员]
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
