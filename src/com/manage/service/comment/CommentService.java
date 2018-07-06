package com.manage.service.comment;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Comment;


public interface CommentService {

	public List<Comment> getCommentInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//插入影院信息
	public boolean insertComment(Comment p);
	
	//修改影院信息
	public boolean updateComment(Comment p);

	//根据影院id删除影院信息
	public boolean deleteCommentById(@Param("id")Integer id);
}
