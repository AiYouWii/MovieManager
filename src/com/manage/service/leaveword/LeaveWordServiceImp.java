package com.manage.service.leaveword;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.leaveword.LeaveWordMapper;
import com.manage.pojo.LeaveWord;

@Service
public class LeaveWordServiceImp implements LeaveWordService{
	/*
	 * 实例化DAO层对象
	 */
	@Resource
	private LeaveWordMapper hm;
	
	/**
	 * getLeaveWordInfo
	 * 获取列表 
	 */
	@Override
	public List<LeaveWord> getLeaveWordInfo(Integer start, Integer size) {
		// TODO Auto-generated method stub
		List<LeaveWord> pa=null;
		pa=hm.getLeaveWordInfo(start, size);
		return pa;
	}

	/**
	 * [insertLeaveWord 插入新增]
	 * @param  p [管理员的信息]
	 * @return   [是否插入成功]
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
	 * [updateLeaveWord 修改信息]
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
	 * [deleteLeaveWordById 根据id删除]
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
