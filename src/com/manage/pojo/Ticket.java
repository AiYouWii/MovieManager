package com.manage.pojo;

public class Ticket {
	private Integer id;
	private String orderNum;
	private Integer number;
	private String status;
	private Integer mv_action_id;
	private Integer user_id;
	private Integer siteNum;
	private Person person;
	private String createTime;
	private String updateTime;
	private MovieAction movieaction;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getSiteNum() {
		return siteNum;
	}
	public void setSiteNum(Integer siteNum) {
		this.siteNum = siteNum;
	}
	public Integer getMv_action_id() {
		return mv_action_id;
	}
	public void setMv_action_id(Integer mv_action_id) {
		this.mv_action_id = mv_action_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
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
	public MovieAction getMovieaction() {
		return movieaction;
	}
	public void setMovieaction(MovieAction movieaction) {
		this.movieaction = movieaction;
	}
}
