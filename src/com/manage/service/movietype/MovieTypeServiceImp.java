package com.manage.service.movietype;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.movietype.MovieTypeMapper;
import com.manage.pojo.MovieType;

@Service
public class MovieTypeServiceImp implements MovieTypeService{
	/*
	 * ʵ����DAO�����
	 */
	@Resource
	private MovieTypeMapper mm;
	
	/**
	 * ��ȡ���������б� 
	 */
	@Override
	public List<MovieType> getMovieTypeInfo(Integer start, Integer size) {
		// TODO Auto-generated method stub
		List<MovieType> pa=null;
		pa=mm.getMovieTypeInfo(start, size);
		return pa;
	}

	/**
	 * [insertPublishArea ����������������]
	 * @param  p [����Ա����Ϣ]
	 * @return   [�Ƿ����ɹ�]
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
	 * [updatePublishArea �޸ķ���������Ϣ]
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
	 * [deletePublishAreaById ���ݷ�������idɾ����������]
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
