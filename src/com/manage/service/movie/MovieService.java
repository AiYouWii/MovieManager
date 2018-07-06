package com.manage.service.movie;

import com.manage.pojo.Movie;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MovieService {
	
	//��id����ѯ��Ӱ��Ϣ
	public Movie getMovieInfoById(String id);

	public Integer selectMovieCount();

	public List<Movie> getMovieInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//�����û���Ϣ
	public boolean insertMovie(Movie p);
	
	//�޸ĵ�Ӱ��Ϣ
	public boolean updateMovie(Movie p);

	//���ݵ�Ӱidɾ����Ӱ
	public boolean deleteMovieById(Integer id);
}
