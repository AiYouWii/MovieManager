package com.manage.service.hall;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Hall;


public interface HallService {

	public List<Hall> getHallInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//����Ӱ����Ϣ
	public boolean insertHall(Hall p);
	
	//�޸�Ӱ����Ϣ
	public boolean updateHall(Hall p);

	//����Ӱ��idɾ��Ӱ����Ϣ
	public boolean deleteHallById(@Param("id")Integer id);
}