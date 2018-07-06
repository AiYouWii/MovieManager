package com.manage.dao.home;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.*;

public interface HomeMapper {
	
	public Person userLogin(@Param("user")String user, @Param("pass")String pass);
	
	//�鿴���е�Ӱ��Ϣ
	public List<Movie> getMovieInfo();
	
	//���ݵ�ӰID��ѯ��Ӱ��ص�����
	public Movie getMovieInfoById(@Param("id")Integer id);
	
	//���ݵ�Ӱid��ѯӰ������
	public List<Comment> getCommentByMId(@Param("id")Integer id);
	
	//��ȡ��Ƭ��Ϣ
	public List<MovieAction> getMovieActionByMId(@Param("id")Integer id);
	
	public Person checkPhone(@Param("user")String user);
	
	public boolean register(Person p);
}