package com.manage.service.movie;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.movie.MovieMapper;
import com.manage.pojo.Movie;


@Service
public class MovieServiceImp implements MovieService{
	
	/*
	 * ʵ����DAO�����
	 */
	@Resource
	private MovieMapper mm;

	@Override
	public Movie getMovieInfoById(String id) {
		Movie per=new Movie();
		per=mm.getMovieInfoById(id);
		return per;
	}
	
	@Override
	public List<Movie> getMovieInfo(Integer start, Integer size) {
        //��װÿҳ��ʾ������
        List<Movie> lists = mm.getMovieInfo(start, size);

        return lists;
	}
	
	/**
	 * [insertMovie ����������Ӱ��Ϣ]
	 * @param  p [��Ӱ��Ϣ]
	 * @return   [�Ƿ����ɹ�]
	 */
	@Override
	public boolean insertMovie(Movie p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(mm.insertMovie(p)){
			flag=true;
		}
		return flag;
	}
	
	/**
	 * [updateMovie �޸ĵ�Ӱ��Ϣ]
	 * @param  p [description]
	 * @return   [description]
	 */
	@Override
	public boolean updateMovie(Movie p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(mm.updateMovie(p)){
			flag=true;
		}
		return flag;
	}

	/**
	 * [deleteMovieById ���ݵ�Ӱidɾ����Ӱ��Ϣ]
	 * @param  id [description]
	 * @return    [description]
	 */
	@Override
	public boolean deleteMovieById(Integer id){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(mm.deleteMovieById(id)){
			flag=true;
		}
		return flag;
	}

	@Override
	public Integer selectMovieCount() {
		// TODO Auto-generated method stub
		return null;
	}

}
