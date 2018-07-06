package com.manage.service.comment;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.comment.CommentMapper;
import com.manage.pojo.Comment;

@Service
public class CommentServiceImp implements CommentService{
	/*
	 * ʵ����DAO�����
	 */
	@Resource
	private CommentMapper cm;
	
	/**
	 * getCommentInfo
	 * ��ȡ�б� 
	 */
	@Override
	public List<Comment> getCommentInfo(Integer start, Integer size) {
		// TODO Auto-generated method stub
		List<Comment> pa=null;
		pa=cm.getCommentInfo(start, size);
		return pa;
	}

	/**
	 * [insertComment ����]
	 * @param  p []
	 * @return   [�Ƿ����ɹ�]
	 */
	@Override
	public boolean insertComment(Comment p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(cm.insertComment(p)){
			flag=true;
		}
		return flag;
	}
	
	/**
	 * [updateComment �޸���Ϣ]
	 * @param  p [description]
	 * @return   [description]
	 */
	@Override
	public boolean updateComment(Comment p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(cm.updateComment(p)){
			flag=true;
		}
		return flag;
	}

	/**
	 * [deleteCommentById ����idɾ��]
	 * @param  id [description]
	 * @return    [description]
	 */
	@Override
	public boolean deleteCommentById(Integer id){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(cm.deleteCommentById(id)){
			flag=true;
		}
		return flag;
	}

}
