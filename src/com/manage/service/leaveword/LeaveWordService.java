package com.manage.service.leaveword;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.LeaveWord;


public interface LeaveWordService {

	public List<LeaveWord> getLeaveWordInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//������Ϣ
	public boolean insertLeaveWord(LeaveWord p);
	
	//�޸���Ϣ
	public boolean updateLeaveWord(LeaveWord p);

	//��idɾ��
	public boolean deleteLeaveWordById(@Param("id")Integer id);
}