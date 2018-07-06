package com.manage.service.cinema;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Cinema;


public interface CinemaService {

	public List<Cinema> getCinemaInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//����ӰԺ��Ϣ
	public boolean insertCinema(Cinema p);
	
	//�޸�ӰԺ��Ϣ
	public boolean updateCinema(Cinema p);

	//����ӰԺidɾ��ӰԺ��Ϣ
	public boolean deleteCinemaById(@Param("id")Integer id);
}
