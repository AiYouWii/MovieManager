package com.manage.service.publish;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.PublishArea;


public interface PublishAreaService {

	public List<PublishArea> getPublishAreaInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//���뷢��������Ϣ
	public boolean insertPublishArea(PublishArea p);
	
	//�޸ķ���������Ϣ
	public boolean updatePublishArea(PublishArea p);

	//���ݷ�������idɾ����������
	public boolean deletePublishAreaById(@Param("id")Integer id);
}
