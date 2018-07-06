package com.manage.dao.hall;

import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.manage.pojo.Hall;

public interface HallMapper {
	
	//获取影厅的信息
	public List<Hall> getHallInfo(@Param("start")Integer start, @Param("size")Integer size);

	//插入影厅信息
	public boolean insertHall(Hall p);
	
	//修改影厅信息
	public boolean updateHall(Hall p);

	//根据影厅id删除影厅
	public boolean deleteHallById(@Param("id")Integer id);
}