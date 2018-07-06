package com.manage.service.cinema;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.cinema.CinemaMapper;
import com.manage.pojo.Cinema;

@Service
public class CinemaServiceImp implements CinemaService{
	/*
	 * 实例化DAO层对象
	 */
	@Resource
	private CinemaMapper cm;
	
	/**
	 * getCinemaInfo
	 * 获取影院列表 
	 */
	@Override
	public List<Cinema> getCinemaInfo(Integer start, Integer size) {
		// TODO Auto-generated method stub
		List<Cinema> pa=null;
		pa=cm.getCinemaInfo(start, size);
		return pa;
	}

	/**
	 * [insertCinema 插入新增影院]
	 * @param  p [管理员的信息]
	 * @return   [是否插入成功]
	 */
	@Override
	public boolean insertCinema(Cinema p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(cm.insertCinema(p)){
			flag=true;
		}
		return flag;
	}
	
	/**
	 * [updateCinema 修改影院信息]
	 * @param  p [description]
	 * @return   [description]
	 */
	@Override
	public boolean updateCinema(Cinema p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(cm.updateCinema(p)){
			flag=true;
		}
		return flag;
	}

	/**
	 * [deleteCinemaById 根据影院id删除影院]
	 * @param  id [description]
	 * @return    [description]
	 */
	@Override
	public boolean deleteCinemaById(Integer id){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(cm.deleteCinemaById(id)){
			flag=true;
		}
		return flag;
	}

}
