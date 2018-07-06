package com.manage.service.ticket;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.ticket.TicketMapper;
import com.manage.pojo.Ticket;


@Service
public class TicketServiceImp implements TicketService{
	
	/*
	 * 实例化DAO层对象
	 */
	@Resource
	private TicketMapper tm;
	
	@Override
	public List<Ticket> getTicketInfo(Integer start, Integer size) {
        //封装每页显示的数据
        List<Ticket> lists = tm.getTicketInfo(start, size);

        return lists;
	}
	
	/**
	 * [insertTicket 插入新增信息]
	 * @param  p [信息]
	 * @return   [是否插入成功]
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
	 * [updateTicket 修改信息]
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
	 * [deleteTicketById 根据id删除信息]
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
        //封装每页显示的数据
        List<Ticket> lists = tm.getTicketInfoByUid(user_id);

        return lists;
	}
}
