package com.manage.service.cinema;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.cinema.CinemaMapper;
import com.manage.pojo.Cinema;

@Service
public class CinemaServiceImp implements CinemaService{
	/*
	 * ʵ����DAO�����
	 */
	@Resource
	private CinemaMapper cm;
	
	/**
	 * getCinemaInfo
	 * ��ȡӰԺ�б� 
	 */
	@Override
	public List<Cinema> getCinemaInfo(Integer start, Integer size) {
		// TODO Auto-generated method stub
		List<Cinema> pa=null;
		pa=cm.getCinemaInfo(start, size);
		return pa;
	}

	/**
	 * [insertCinema ��������ӰԺ]
	 * @param  p [����Ա����Ϣ]
	 * @return   [�Ƿ����ɹ�]
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
	 * [updateCinema �޸�ӰԺ��Ϣ]
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
	 * [deleteCinemaById ����ӰԺidɾ��ӰԺ]
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
