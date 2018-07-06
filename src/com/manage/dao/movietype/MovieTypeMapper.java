package com.manage.dao.movietype;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.MovieType;

public interface MovieTypeMapper {
	
	public List<MovieType> getMovieTypeInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//�����Ӱ������Ϣ
	public boolean insertMovieType(MovieType p);
	
	//�޸ĵ�Ӱ������Ϣ
	public boolean updateMovieType(MovieType p);

	//���ݵ�Ӱ����idɾ����Ӱ����
	public boolean deleteMovieTypeById(@Param("id")Integer id);

}
