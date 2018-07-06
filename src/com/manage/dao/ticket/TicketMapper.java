package com.manage.dao.ticket;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Ticket;

public interface TicketMapper {

	/**
     * ��ҳ����������getTicketInfo limit��ҳ����
     * @param map
     * @return
     */
	public List<Ticket> getTicketInfo(@Param("start")Integer start, @Param("size")Integer size);

	//���붩����Ϣ
	public boolean insertTicket(Ticket t);
	
	//�޸Ķ�����Ϣ
	public boolean updateTicket(Ticket t);

	//���ݶ���idɾ������
	public boolean deleteTicketById(@Param("id")Integer id);
	
	public List<Ticket> getTicketInfoByUid(@Param("user_id")Integer user_id);
}