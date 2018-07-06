package com.manage.service.ticket;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.ticket.TicketMapper;
import com.manage.pojo.Ticket;


@Service
public class TicketServiceImp implements TicketService{
	
	/*
	 * ʵ����DAO�����
	 */
	@Resource
	private TicketMapper tm;
	
	@Override
	public List<Ticket> getTicketInfo(Integer start, Integer size) {
        //��װÿҳ��ʾ������
        List<Ticket> lists = tm.getTicketInfo(start, size);

        return lists;
	}
	
	/**
	 * [insertTicket ����������Ϣ]
	 * @param  p [��Ϣ]
	 * @return   [�Ƿ����ɹ�]
	 */
	@Override
	public boolean insertTicket(Ticket p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(tm.insertTicket(p)){
			flag=true;
		}
		return flag;
	}
	
	/**
	 * [updateTicket �޸���Ϣ]
	 * @param  p [description]
	 * @return   [description]
	 */
	@Override
	public boolean updateTicket(Ticket p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(tm.updateTicket(p)){
			flag=true;
		}
		return flag;
	}

	/**
	 * [deleteTicketById ����idɾ����Ϣ]
	 * @param  id [description]
	 * @return    [description]
	 */
	@Override
	public boolean deleteTicketById(Integer id){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(tm.deleteTicketById(id)){
			flag=true;
		}
		return flag;
	}

	@Override
	public List<Ticket> getTicketInfoByUid(Integer user_id) {
        //��װÿҳ��ʾ������
        List<Ticket> lists = tm.getTicketInfoByUid(user_id);

        return lists;
	}
}
