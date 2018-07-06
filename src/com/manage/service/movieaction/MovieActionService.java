package com.manage.service.movieaction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.MovieAction;

public interface MovieActionService {
	public List<MovieAction> getMovieActionInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//������Ϣ
	public boolean insertMovieAction(MovieAction p);
	
	//�޸���Ϣ
	public boolean updateMovieAction(MovieAction p);

	//����idɾ��
	public boolean deleteMovieActionById(Integer id);
}
