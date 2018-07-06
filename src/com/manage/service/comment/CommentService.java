package com.manage.service.comment;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Comment;


public interface CommentService {

	public List<Comment> getCommentInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//����ӰԺ��Ϣ
	public boolean insertComment(Comment p);
	
	//�޸�ӰԺ��Ϣ
	public boolean updateComment(Comment p);

	//����ӰԺidɾ��ӰԺ��Ϣ
	public boolean deleteCommentById(@Param("id")Integer id);
}
