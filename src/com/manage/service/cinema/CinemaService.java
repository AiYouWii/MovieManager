package com.manage.service.cinema;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Cinema;


public interface CinemaService {

	public List<Cinema> getCinemaInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//插入影院信息
	public boolean insertCinema(Cinema p);
	
	//修改影院信息
	public boolean updateCinema(Cinema p);

	//根据影院id删除影院信息
	public boolean deleteCinemaById(@Param("id")Integer id);
}
