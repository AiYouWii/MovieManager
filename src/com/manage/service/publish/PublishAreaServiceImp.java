package com.manage.service.publish;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.publish.PublishAreaMapper;
import com.manage.pojo.PublishArea;

@Service
public class PublishAreaServiceImp implements PublishAreaService{
	/*
	 * 实例化DAO层对象
	 */
	@Resource
	private PublishAreaMapper pm;
	
	/**
	 * 获取发布地区列表 
	 */
	@Override
	public List<PublishArea> getPublishAreaInfo(Integer start, Integer size) {
		// TODO Auto-generated method stub
		List<PublishArea> pa=null;
		pa=pm.getPublishAreaInfo(start, size);
		return pa;
	}

	/**
	 * [insertPublishArea 插入新增发布地区]
	 * @param  p [管理员的信息]
	 * @return   [是否插入成功]
	 */
	@Override
	public boolean insertPublishArea(PublishArea p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(pm.insertPublishArea(p)){
			flag=true;
		}
		return flag;
	}
	
	/**
	 * [updatePublishArea 修改发布地区信息]
	 * @param  p [description]
	 * @return   [description]
	 */
	@Override
	public boolean updatePublishArea(PublishArea p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(pm.updatePublishArea(p)){
			flag=true;
		}
		return flag;
	}

	/**
	 * [deletePublishAreaById 根据发布地区id删除发布地区]
	 * @param  id [description]
	 * @return    [description]
	 */
	@Override
	public boolean deletePublishAreaById(Integer id){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(pm.deletePublishAreaById(id)){
			flag=true;
		}
		return flag;
	}

}
