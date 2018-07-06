package com.manage.dao.movieaction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.MovieAction;

public interface MovieActionMapper {
	/**
     * ��ҳ����������getTicketInfo limit��ҳ����
     * @param map
     * @return
     */
	public List<MovieAction> getMovieActionInfo(@Param("start")Integer start, @Param("size")Integer size);

	//���붩����Ϣ
	public boolean insertMovieAction(MovieAction t);
	
	//�޸Ķ�����Ϣ
	public boolean updateMovieAction(MovieAction t);

	//���ݶ���idɾ������
	public boolean deleteMovieActionById(@Param("id")Integer id);
}
