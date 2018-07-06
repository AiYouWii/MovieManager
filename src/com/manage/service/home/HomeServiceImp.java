package com.manage.service.home;
import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import java.util.List;
import com.manage.dao.home.HomeMapper;
import com.manage.pojo.Comment;
import com.manage.pojo.Movie;
import com.manage.pojo.MovieAction;
import com.manage.pojo.Person;
@Service
public class HomeServiceImp implements HomeService{
	/*
	 * ʵ����DAO�����
	 */
	@Resource
	private HomeMapper hm;
	
	//�û���¼
	@Override
	public Person userLogin(String user, String pass) {
		Person person=hm.userLogin(user, pass);
		return person;
	}
	
	//��ȡ��Ӱ���б�
	@Override
	public List<Movie> getMovieInfo() {
		List<Movie> movieList=null;
		movieList=hm.getMovieInfo();
		return movieList;
	}
	
	//���ݵ�Ӱ��ID��ȡ��Ӱ����Ϣ
	@Override
	public Movie getMovieInfoById(Integer id) {
		Movie movie=hm.getMovieInfoById(id);
		return movie;
	}
	
	//��ȡӰ�����б�
	@Override
	public List<Comment> getCommentByMId(Integer id) {
		List<Comment> commentList=null;
		commentList=hm.getCommentByMId(id);
		return commentList;
	}
	
	//��ȡ��Ƭ���б�
	@Override
	public List<MovieAction> getMovieActionByMId(Integer id){
		List<MovieAction> mvaList=null;
		mvaList=hm.getMovieActionByMId(id);
		return mvaList;
	}
	
	public Person checkPhone(String user){
		Person person=hm.checkPhone(user);
		return person;
	}
	
	@Override
	public boolean register(Person p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(hm.register(p)){
			flag=true;
		}
		return flag;
	}
}
