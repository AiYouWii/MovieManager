package com.manage.service.publish;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.publish.PublishAreaMapper;
import com.manage.pojo.PublishArea;

@Service
public class PublishAreaServiceImp implements PublishAreaService{
	/*
	 * ʵ����DAO�����
	 */
	@Resource
	private PublishAreaMapper pm;
	
	/**
	 * ��ȡ���������б� 
	 */
	@Override
	public List<PublishArea> getPublishAreaInfo(Integer start, Integer size) {
		// TODO Auto-generated method stub
		List<PublishArea> pa=null;
		pa=pm.getPublishAreaInfo(start, size);
		return pa;
	}

	/**
	 * [insertPublishArea ����������������]
	 * @param  p [����Ա����Ϣ]
	 * @return   [�Ƿ����ɹ�]
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
	 * [updatePublishArea �޸ķ���������Ϣ]
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
	 * [deletePublishAreaById ���ݷ�������idɾ����������]
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
