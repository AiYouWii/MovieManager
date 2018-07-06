package com.manage.service.hall;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.hall.HallMapper;
import com.manage.pojo.Hall;

@Service
public class HallServiceImp implements HallService{
	/*
	 * ʵ����DAO�����
	 */
	@Resource
	private HallMapper hm;
	
	/**
	 * getHallInfo
	 * ��ȡӰ���б� 
	 */
	@Override
	public List<Hall> getHallInfo(Integer start, Integer size) {
		// TODO Auto-generated method stub
		List<Hall> pa=null;
		pa=hm.getHallInfo(start, size);
		return pa;
	}

	/**
	 * [insertHall ��������Ӱ��]
	 * @param  p [����Ա����Ϣ]
	 * @return   [�Ƿ����ɹ�]
	 */
	@Override
	public boolean insertHall(Hall p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(hm.insertHall(p)){
			flag=true;
		}
		return flag;
	}
	
	/**
	 * [updateHall �޸�Ӱ����Ϣ]
	 * @param  p [description]
	 * @return   [description]
	 */
	@Override
	public boolean updateHall(Hall p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(hm.updateHall(p)){
			flag=true;
		}
		return flag;
	}

	/**
	 * [deleteHallById ����Ӱ��idɾ��Ӱ��]
	 * @param  id [description]
	 * @return    [description]
	 */
	@Override
	public boolean deleteHallById(Integer id){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(hm.deleteHallById(id)){
			flag=true;
		}
		return flag;
	}

}
