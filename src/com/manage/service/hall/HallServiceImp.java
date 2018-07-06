package com.manage.service.hall;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.hall.HallMapper;
import com.manage.pojo.Hall;

@Service
public class HallServiceImp implements HallService{
	/*
	 * 实例化DAO层对象
	 */
	@Resource
	private HallMapper hm;
	
	/**
	 * getHallInfo
	 * 获取影厅列表 
	 */
	@Override
	public List<Hall> getHallInfo(Integer start, Integer size) {
		// TODO Auto-generated method stub
		List<Hall> pa=null;
		pa=hm.getHallInfo(start, size);
		return pa;
	}

	/**
	 * [insertHall 插入新增影厅]
	 * @param  p [管理员的信息]
	 * @return   [是否插入成功]
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
	 * [updateHall 修改影厅信息]
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
	 * [deleteHallById 根据影厅id删除影厅]
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
