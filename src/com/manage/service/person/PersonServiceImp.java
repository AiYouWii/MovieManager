package com.manage.service.person;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manage.dao.person.PersonMapper;
import com.manage.pojo.Person;


@Service
public class PersonServiceImp implements PersonService{
	
	/*
	 * ʵ����DAO�����
	 */
	@Resource
	private PersonMapper sm;

	/*
	 * �û���¼
	 */
	@Override
	public Person VipLogin(String user, String pass) {
		Person s=sm.VipLogin(user, pass);
		return s;
	}

	/*
	 * �첽��ѯ�û��Ƿ���ڲ���
	 */
	@Override
	public boolean checkUserIsExist(String user) {
		boolean flag=false;
		Person s=sm.checkUserIsExist(user);
		if(s!=null){
			flag=true;
		}
		return flag;
	}

	@Override
	public Person getUserInfoById(String id) {
		Person per=new Person();
		per=sm.getUserInfoById(id);
		return per;
	}
	
	@Override
	public List<Person> getUserInfo(Integer start, Integer size) {
        List<Person> lists = sm.getUserInfo(start, size);
        return lists;
	}
	
	/**
	 * [���������û���Ϣ]
	 * @param  p [����Ա����Ϣ]
	 * @return   [�Ƿ����ɹ�]
	 */
	@Override
	public boolean insertPerson(Person p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(sm.insertPerson(p)){
			flag=true;
		}
		return flag;
	}
	
	/**
	 * [updatePerson �޸��û���Ϣ]
	 * @param  p [description]
	 * @return   [description]
	 */
	@Override
	public boolean updatePerson(Person p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(sm.updatePerson(p)){
			flag=true;
		}
		return flag;
	}

	/**
	 * [deletePersonById �����û�idɾ���û���Ϣ]
	 * @param  id [description]
	 * @return    [description]
	 */
	@Override
	public boolean deletePersonById(Integer id){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(sm.deletePersonById(id)){
			flag=true;
		}
		return flag;
	}

	@Override
	public Integer selectUserCount() {
		// TODO Auto-generated method stub
		return null;
	}
}
