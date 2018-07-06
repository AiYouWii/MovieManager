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
	 * 实例化DAO层对象
	 */
	@Resource
	private MovieActionMapper tm;
	
	@Override
	public List<MovieAction> getMovieActionInfo(Integer start, Integer size) {
        //封装每页显示的数据
        List<MovieAction> lists = tm.getMovieActionInfo(start, size);

        return lists;
	}
	
	/**
	 * [insertMovieAction 插入新增信息]
	 * @param  p [信息]
	 * @return   [是否插入成功]
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
	 * [updateMovieAction 修改信息]
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
	 * [deleteMovieActionById 根据id删除信息]
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
