package com.entity.vo;

import com.entity.NewsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * Announcement Information
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
public class NewsVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 *
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
