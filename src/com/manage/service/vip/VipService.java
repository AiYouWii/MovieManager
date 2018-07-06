package com.manage.service.vip;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Vip;


public interface VipService {
	
	//查看所有管理员信息
	public List<Vip> getVipInfo(@Param("start")Integer start, @Param("size")Integer size);

	//插入vip信息
	public boolean insertVip(Vip p);

	//修改vip类型信息
	public boolean updateVip(Vip p);

	//根据用户id删除vip类型
	public boolean deleteVipById(Integer id);

	//根据vip id获取vip信息
	public Vip getVipInfoById(@Param("id")Integer id);
}
