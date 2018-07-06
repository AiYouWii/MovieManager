package com.manage.service.ticket;

import com.manage.pojo.Ticket;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TicketService {
	
	public List<Ticket> getTicketInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//插入信息
	public boolean insertTicket(Ticket p);
	
	//修改信息
	public boolean updateTicket(Ticket p);

	//根据id删除
	public boolean deleteTicketById(Integer id);
	
	public List<Ticket> getTicketInfoByUid(@Param("user_id")Integer user_id);
}
