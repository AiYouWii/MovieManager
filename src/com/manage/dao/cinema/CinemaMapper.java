package com.manage.dao.cinema;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Cinema;

public interface CinemaMapper {
	
	public List<Cinema> getCinemaInfo(@Param("start")Integer start,@Param("size")Integer size);
	
	//插入电影类型信息
	public boolean insertCinema(Cinema p);
	
	//修改电影类型信息
	public boolean updateCinema(Cinema p);

	//根据电影类型id删除电影类型
	public boolean deleteCinemaById(@Param("id")Integer id);

}
