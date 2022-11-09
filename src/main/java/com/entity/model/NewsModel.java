package com.entity.model;

import com.entity.NewsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * Announcement Information
 * Entity class for receiving passed parameters
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
public class NewsModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * Introduction
	 */
	
	private String introduction;
		
	/**
	 * Pictures
	 */
	
	private String picture;
		
	/**
	 * Content
	 */
	
	private String content;
				
	
	/**
	 * Setting：Introduction
	 */
	 
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	/**
	 * Get：Introduction
	 */
	public String getIntroduction() {
		return introduction;
	}
				
	
	/**
	 * Setting：Pictures
	 */
	 
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/**
	 * Get：Pictures
	 */
	public String getPicture() {
		return picture;
	}
				
	
	/**
	 * Setting：Content
	 */
	 
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Get：Content
	 */
	public String getContent() {
		return content;
	}
			
}
