package com.manage.dao.ticket;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Ticket;

public interface TicketMapper {

	/**
     * 分页操作，调用getTicketInfo limit分页方法
     * @param map
     * @return
     */
	public List<Ticket> getTicketInfo(@Param("start")Integer start, @Param("size")Integer size);

	//插入订单信息
	public boolean insertTicket(Ticket t);
	
	//修改订单信息
	public boolean updateTicket(Ticket t);

	//根据订单id删除订单
	public boolean deleteTicketById(@Param("id")Integer id);
	
	public List<Ticket> getTicketInfoByUid(@Param("user_id")Integer user_id);
}