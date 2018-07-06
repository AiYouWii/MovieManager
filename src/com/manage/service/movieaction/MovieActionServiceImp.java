package com.manage.service.movieaction;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.movieaction.MovieActionMapper;
import com.manage.pojo.MovieAction;
import com.manage.service.movieaction.MovieActionService;

@Service
public class MovieActionServiceImp implements MovieActionService{
	/*
	 * ʵ����DAO�����
	 */
	@Resource
	private MovieActionMapper tm;
	
	@Override
	public List<MovieAction> getMovieActionInfo(Integer start, Integer size) {
        //��װÿҳ��ʾ������
        List<MovieAction> lists = tm.getMovieActionInfo(start, size);

        return lists;
	}
	
	/**
	 * [insertMovieAction ����������Ϣ]
	 * @param  p [��Ϣ]
	 * @return   [�Ƿ����ɹ�]
	 */
	@Override
	public boolean insertMovieAction(MovieAction p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(tm.insertMovieAction(p)){
			flag=true;
		}
		return flag;
	}
	
	/**
	 * [updateMovieAction �޸���Ϣ]
	 * @param  p [description]
	 * @return   [description]
	 */
	@Override
	public boolean updateMovieAction(MovieAction p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(tm.updateMovieAction(p)){
			flag=true;
		}
		return flag;
	}

	/**
	 * [deleteMovieActionById ����idɾ����Ϣ]
	 * @param  id [description]
	 * @return    [description]
	 */
	@Override
	public boolean deleteMovieActionById(Integer id){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(tm.deleteMovieActionById(id)){
			flag=true;
		}
		return flag;
	}
}
