package com.manage.service.hall;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Hall;


public interface HallService {

	public List<Hall> getHallInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//插入影厅信息
	public boolean insertHall(Hall p);
	
	//修改影厅信息
	public boolean updateHall(Hall p);

	//根据影厅id删除影厅信息
	public boolean deleteHallById(@Param("id")Integer id);
}