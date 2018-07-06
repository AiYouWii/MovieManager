package com.manage.service.vip;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Vip;


public interface VipService {
	
	//�鿴���й���Ա��Ϣ
	public List<Vip> getVipInfo(@Param("start")Integer start, @Param("size")Integer size);

	//����vip��Ϣ
	public boolean insertVip(Vip p);

	//�޸�vip������Ϣ
	public boolean updateVip(Vip p);

	//�����û�idɾ��vip����
	public boolean deleteVipById(Integer id);

	//����vip id��ȡvip��Ϣ
	public Vip getVipInfoById(@Param("id")Integer id);
}
