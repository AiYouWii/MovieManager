package com.manage.service.vip;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.vip.VipMapper;
import com.manage.pojo.Vip;

@Service
public class VipServiceImp implements VipService{
	/*
	 * ʵ����DAO�����
	 */
	@Resource
	private VipMapper am;

	/**
	 * ��ȡvip ���� �б�
	 */
	@Override
	public List<Vip> getVipInfo(Integer start, Integer size) {
		// TODO Auto-generated method stub
		List<Vip> VipList=null;
		VipList=am.getVipInfo(start, size);
		return VipList;
	}

	/**
	 * [��������vip ����]
	 * @param  p [vip���͵���Ϣ]
	 * @return   [�Ƿ����ɹ�]
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
	 * [updateVip �޸�vip������Ϣ]
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
	 * [deleteVipById ����vip���� id ɾ��vip����]
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
	 * [getVipInfoById ����vipid��ȡ��ϸ��Ϣ]
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
