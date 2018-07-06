package com.manage.service.comment;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.comment.CommentMapper;
import com.manage.pojo.Comment;

@Service
public class CommentServiceImp implements CommentService{
	/*
	 * 实例化DAO层对象
	 */
	@Resource
	private CommentMapper cm;
	
	/**
	 * getCommentInfo
	 * 获取列表 
	 */
	@Override
	public List<Comment> getCommentInfo(Integer start, Integer size) {
		// TODO Auto-generated method stub
		List<Comment> pa=null;
		pa=cm.getCommentInfo(start, size);
		return pa;
	}

	/**
	 * [insertComment 插入]
	 * @param  p []
	 * @return   [是否插入成功]
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
	 * [updateComment 修改信息]
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
	 * [deleteCommentById 根据id删除]
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
