package com.manage.service.leaveword;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.leaveword.LeaveWordMapper;
import com.manage.pojo.LeaveWord;

@Service
public class LeaveWordServiceImp implements LeaveWordService{
	/*
	 * ʵ����DAO�����
	 */
	@Resource
	private LeaveWordMapper hm;
	
	/**
	 * getLeaveWordInfo
	 * ��ȡ�б� 
	 */
	@Override
	public List<LeaveWord> getLeaveWordInfo(Integer start, Integer size) {
		// TODO Auto-generated method stub
		List<LeaveWord> pa=null;
		pa=hm.getLeaveWordInfo(start, size);
		return pa;
	}

	/**
	 * [insertLeaveWord ��������]
	 * @param  p [����Ա����Ϣ]
	 * @return   [�Ƿ����ɹ�]
	 */
	@Override
	public boolean insertLeaveWord(LeaveWord p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(hm.insertLeaveWord(p)){
			flag=true;
		}
		return flag;
	}
	
	/**
	 * [updateLeaveWord �޸���Ϣ]
	 * @param  p [description]
	 * @return   [description]
	 */
	@Override
	public boolean updateLeaveWord(LeaveWord p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(hm.updateLeaveWord(p)){
			flag=true;
		}
		return flag;
	}

	/**
	 * [deleteLeaveWordById ����idɾ��]
	 * @param  id [description]
	 * @return    [description]
	 */
	@Override
	public boolean deleteLeaveWordById(Integer id){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(hm.deleteLeaveWordById(id)){
			flag=true;
		}
		return flag;
	}

}
