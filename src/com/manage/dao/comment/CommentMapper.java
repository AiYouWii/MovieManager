package com.manage.dao.comment;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Comment;

public interface CommentMapper {
	
	public List<Comment> getCommentInfo(@Param("start")Integer start,@Param("size")Integer size);
	
	//插入信息
	public boolean insertComment(Comment p);
	
	//修改信息
	public boolean updateComment(Comment p);

	//根据id删除
	public boolean deleteCommentById(@Param("id")Integer id);

}
