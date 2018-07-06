package com.manage.dao.movie;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Movie;

public interface MovieMapper {
	
	//��id����ѯ��Ӱ��Ϣ
	public Movie getMovieInfoById(@Param("id")String id);

	/**
     * ��ҳ����������getUserInfo limit��ҳ����
     * @param map
     * @return
     */
	public List<Movie> getMovieInfo(@Param("start")Integer start, @Param("size")Integer size);

	/**
	 * [selectUserCount ��ѯ��Ӱ����]
	 * @return [description]
	 */
	public Integer selectMovieCount();

	//�����Ӱ��Ϣ
	public boolean insertMovie(Movie p);
	
	//�޸ĵ�Ӱ��Ϣ
	public boolean updateMovie(Movie p);

	//���ݵ�Ӱidɾ����Ӱ
	public boolean deleteMovieById(@Param("id")Integer id);
}