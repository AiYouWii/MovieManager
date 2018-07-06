package com.manage.dao.cinema;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Cinema;

public interface CinemaMapper {
	
	public List<Cinema> getCinemaInfo(@Param("start")Integer start,@Param("size")Integer size);
	
	//�����Ӱ������Ϣ
	public boolean insertCinema(Cinema p);
	
	//�޸ĵ�Ӱ������Ϣ
	public boolean updateCinema(Cinema p);

	//���ݵ�Ӱ����idɾ����Ӱ����
	public boolean deleteCinemaById(@Param("id")Integer id);

}
