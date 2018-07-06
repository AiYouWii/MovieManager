package com.manage.dao.movieaction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.MovieAction;

public interface MovieActionMapper {
	/**
     * 分页操作，调用getTicketInfo limit分页方法
     * @param map
     * @return
     */
	public List<MovieAction> getMovieActionInfo(@Param("start")Integer start, @Param("size")Integer size);

	//插入订单信息
	public boolean insertMovieAction(MovieAction t);
	
	//修改订单信息
	public boolean updateMovieAction(MovieAction t);

	//根据订单id删除订单
	public boolean deleteMovieActionById(@Param("id")Integer id);
}
