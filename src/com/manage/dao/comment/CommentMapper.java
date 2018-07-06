package com.manage.dao.comment;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Comment;

public interface CommentMapper {
	
	public List<Comment> getCommentInfo(@Param("start")Integer start,@Param("size")Integer size);
	
	//������Ϣ
	public boolean insertComment(Comment p);
	
	//�޸���Ϣ
	public boolean updateComment(Comment p);

	//����idɾ��
	public boolean deleteCommentById(@Param("id")Integer id);

}
