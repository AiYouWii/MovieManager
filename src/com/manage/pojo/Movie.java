package com.manage.pojo;
import java.util.List; 

public class Movie {
	private Integer id;
	private String name;
	private String publish_time;
	private Integer long_time;
	private Integer area_id;
	private Integer type_id;
	private String img;
	private String info;
	private Float ticket_price;
	private PublishArea publishArea;
	private MovieType movieType;
	private List<PublishArea> publishAreaList;
	private List<MovieType> movieTypeList;
	private String createTime;
	private String updateTime;

	//这里待自动生成
	
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLong_time() {
		return long_time;
	}
	public void setLong_time(Integer long_time) {
		this.long_time = long_time;
	}
	public Integer getArea_id() {
		return area_id;
	}
	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Float getTicket_price() {
		return ticket_price;
	}
	public void setTicket_price(Float ticket_price) {
		this.ticket_price = ticket_price;
	}
	public PublishArea getPublishArea() {
		return publishArea;
	}
	public void setPublishArea(PublishArea publishArea) {
		this.publishArea = publishArea;
	}
	public MovieType getMovieType() {
		return movieType;
	}
	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}
	public List<PublishArea> getPublishAreaList() {
		return publishAreaList;
	}
	public void setPublishAreaList(List<PublishArea> publishAreaList) {
		this.publishAreaList = publishAreaList;
	}
	public List<MovieType> getMovieTypeList() {
		return movieTypeList;
	}
	public void setMovieTypeList(List<MovieType> movieTypeList) {
		this.movieTypeList = movieTypeList;
	}
	public String getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(String publish_time) {
		this.publish_time = publish_time;
	}
}
