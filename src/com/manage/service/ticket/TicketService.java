package com.manage.service.ticket;

import com.manage.pojo.Ticket;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TicketService {
	
	public List<Ticket> getTicketInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//������Ϣ
	public boolean insertTicket(Ticket p);
	
	//�޸���Ϣ
	public boolean updateTicket(Ticket p);

	//����idɾ��
	public boolean deleteTicketById(Integer id);
	
	public List<Ticket> getTicketInfoByUid(@Param("user_id")Integer user_id);
}
