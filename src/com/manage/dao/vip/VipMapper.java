package com.manage.dao.vip;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Vip;

public interface VipMapper {
	
	public List<Vip> getVipInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//插入会员信息
	public boolean insertVip(Vip p);
	
	//修改会员信息
	public boolean updateVip(Vip p);

	//根据会员id删除会员类型
	public boolean deleteVipById(@Param("id")Integer id);

	//根据会员id获取会员信息
	public Vip getVipInfoById(@Param("id")Integer id);

}