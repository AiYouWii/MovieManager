package com.manage.dao.vip;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Vip;

public interface VipMapper {
	
	public List<Vip> getVipInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//�����Ա��Ϣ
	public boolean insertVip(Vip p);
	
	//�޸Ļ�Ա��Ϣ
	public boolean updateVip(Vip p);

	//���ݻ�Աidɾ����Ա����
	public boolean deleteVipById(@Param("id")Integer id);

	//���ݻ�Աid��ȡ��Ա��Ϣ
	public Vip getVipInfoById(@Param("id")Integer id);

}