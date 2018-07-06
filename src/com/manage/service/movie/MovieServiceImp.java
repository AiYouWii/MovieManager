package com.manage.service.movie;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.movie.MovieMapper;
import com.manage.pojo.Movie;


@Service
public class MovieServiceImp implements MovieService{
	
	/*
	 * 实例化DAO层对象
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
        //封装每页显示的数据
        List<Movie> lists = mm.getMovieInfo(start, size);

        return lists;
	}
	
	/**
	 * [insertMovie 插入新增电影信息]
	 * @param  p [电影信息]
	 * @return   [是否插入成功]
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
	 * [updateMovie 修改电影信息]
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
	 * [deleteMovieById 根据电影id删除电影信息]
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
