package com.manage.pojo;

import java.util.List;

public class Person {
	private Integer id;
	private String user;
	private String pass;
	private String username;
	private String sex;
	private String createTime;
	private String updateTime;
	private String vip_died_line;
	private Integer vip_id;
	private String level;
	private Integer discount;
	private float cost;
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	private List<Vip> vipList;
	public List<Vip> getVipList() {
		return vipList;
	}
	public void setVipList(List<Vip> vipList) {
		this.vipList = vipList;
	}
	private Vip vip;
	public Person() {  
        super();  
    }  
	public Person(Vip vip) {  
        super();  
        this.vip = vip;
        
    }  
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getVip_died_line() {
		return vip_died_line;
	}
	public void setVip_died_line(String vip_died_line) {
		this.vip_died_line = vip_died_line;
	}
	public Vip getVip() {
		return vip;
	}
	public void setVip(Vip vip) {
		this.vip = vip;
	}
	public Integer getVip_id() {
		return vip_id;
	}
	public void setVip_id(Integer vip_id) {
		this.vip_id = vip_id;
	}
}
