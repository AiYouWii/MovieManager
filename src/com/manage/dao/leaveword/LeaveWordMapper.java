package com.manage.dao.leaveword;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.LeaveWord;

public interface LeaveWordMapper {
	
	public List<LeaveWord> getLeaveWordInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//插入信息
	public boolean insertLeaveWord(LeaveWord p);
	
	//修改信息
	public boolean updateLeaveWord(LeaveWord p);

	//根据id删除
	public boolean deleteLeaveWordById(@Param("id")Integer id);

}
