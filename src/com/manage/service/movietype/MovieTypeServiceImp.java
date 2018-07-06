package com.manage.service.movietype;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.movietype.MovieTypeMapper;
import com.manage.pojo.MovieType;

@Service
public class MovieTypeServiceImp implements MovieTypeService{
	/*
	 * 实例化DAO层对象
	 */
	@Resource
	private MovieTypeMapper mm;
	
	/**
	 * 获取发布地区列表 
	 */
	@Override
	public List<MovieType> getMovieTypeInfo(Integer start, Integer size) {
		// TODO Auto-generated method stub
		List<MovieType> pa=null;
		pa=mm.getMovieTypeInfo(start, size);
		return pa;
	}

	/**
	 * [insertPublishArea 插入新增发布地区]
	 * @param  p [管理员的信息]
	 * @return   [是否插入成功]
	 */
	@Override
	public boolean insertMovieType(MovieType p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(mm.insertMovieType(p)){
			flag=true;
		}
		return flag;
	}
	
	/**
	 * [updatePublishArea 修改发布地区信息]
	 * @param  p [description]
	 * @return   [description]
	 */
	@Override
	public boolean updateMovieType(MovieType p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(mm.updateMovieType(p)){
			flag=true;
		}
		return flag;
	}

	/**
	 * [deletePublishAreaById 根据发布地区id删除发布地区]
	 * @param  id [description]
	 * @return    [description]
	 */
	@Override
	public boolean deleteMovieTypeById(Integer id){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(mm.deleteMovieTypeById(id)){
			flag=true;
		}
		return flag;
	}

}
