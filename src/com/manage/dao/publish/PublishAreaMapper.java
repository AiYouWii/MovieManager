package com.manage.dao.publish;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.PublishArea;

public interface PublishAreaMapper {
	
	public List<PublishArea> getPublishAreaInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//插入发布地区信息
	public boolean insertPublishArea(PublishArea p);
	
	//修改发布地区信息
	public boolean updatePublishArea(PublishArea p);

	//根据发布地区id删除发布地区
	public boolean deletePublishAreaById(@Param("id")Integer id);

}
