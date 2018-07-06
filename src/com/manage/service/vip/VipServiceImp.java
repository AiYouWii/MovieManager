package com.manage.service.vip;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.vip.VipMapper;
import com.manage.pojo.Vip;

@Service
public class VipServiceImp implements VipService{
	/*
	 * 实例化DAO层对象
	 */
	@Resource
	private VipMapper am;

	/**
	 * 获取vip 类型 列表
	 */
	@Override
	public List<Vip> getVipInfo(Integer start, Integer size) {
		// TODO Auto-generated method stub
		List<Vip> VipList=null;
		VipList=am.getVipInfo(start, size);
		return VipList;
	}

	/**
	 * [插入新增vip 类型]
	 * @param  p [vip类型的信息]
	 * @return   [是否插入成功]
	 */
	@Override
	public boolean insertVip(Vip p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(am.insertVip(p)){
			flag=true;
		}
		return flag;
	}
	
	/**
	 * [updateVip 修改vip类型信息]
	 * @param  p [description]
	 * @return   [description]
	 */
	@Override
	public boolean updateVip(Vip p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(am.updateVip(p)){
			flag=true;
		}
		return flag;
	}

	/**
	 * [deleteVipById 根据vip类型 id 删除vip类型]
	 * @param  id [description]
	 * @return    [description]
	 */
	@Override
	public boolean deleteVipById(Integer id){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(am.deleteVipById(id)){
			flag=true;
		}
		return flag;
	}

	/**
	 * [getVipInfoById 根据vipid获取详细信息]
	 * @param  id [description]
	 * @return    [description]
	 */
	@Override
	public Vip getVipInfoById(Integer id){
		// TODO Auto-generated method stub
		Vip ad = new Vip();
		ad = am.getVipInfoById(id);
		return ad;
	}
}
