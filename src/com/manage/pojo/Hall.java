package com.manage.pojo;
public class Hall {
	
	private Integer id;
	private String hall_name;
	private String address;
	private Integer cinema_id;
	private String createTime;
	private String updateTime;
	private Cinema cinema;
	
	public Hall() {  
        super();  
    }  
	public Hall(Cinema cinema) {  
        super();  
        this.cinema = cinema;
        
    }  
	public Cinema getCinema() {
		return cinema;
	}
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
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
	public Integer getCinema_id() {
		return cinema_id;
	}
	public void setCinema_id(Integer cinema_id) {
		this.cinema_id = cinema_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public void setSite_num(Integer site_num) {
		this.site_num = site_num;
	}
	private Integer site_num;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHall_name() {
		return hall_name;
	}
	public void setHall_name(String hall_name) {
		this.hall_name = hall_name;
	}
	public Integer getSite_num() {
		return site_num;
	}
	public void setAddress(Integer site_num) {
		this.site_num = site_num;
	}
}