package com.manage.dao.hall;

import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.manage.pojo.Hall;

public interface HallMapper {
	
	//��ȡӰ������Ϣ
	public List<Hall> getHallInfo(@Param("start")Integer start, @Param("size")Integer size);

	//����Ӱ����Ϣ
	public boolean insertHall(Hall p);
	
	//�޸�Ӱ����Ϣ
	public boolean updateHall(Hall p);

	//����Ӱ��idɾ��Ӱ��
	public boolean deleteHallById(@Param("id")Integer id);
}