package com.entity.vo;

import com.entity.StoreupEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * Collection Table
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
public class StoreupVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * Collection id
	 */
	
	private Long refid;
		
	/**
	 * Table Name
	 */
	
	private String tablename;
		
	/**
	 * Collection Name
	 */
	
	private String name;
		
	/**
	 * Collection Pictures
	 */
	
	private String picture;
		
	/**
	 * Type(1:Favorite,21:Like,22:Step)
	 */
	
	private String type;
		
	/**
	 * Recommendation Type
	 */
	
	private String inteltype;
				
	
	/**
	 * Setting：Collection id
	 */
	 
	public void setRefid(Long refid) {
		this.refid = refid;
	}
	
	/**
	 * Get：Collection id
	 */
	public Long getRefid() {
		return refid;
	}
				
	
	/**
	 * Setting：Table Name
	 */
	 
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	
	/**
	 * Get：Table Name
	 */
	public String getTablename() {
		return tablename;
	}
				
	
	/**
	 * Setting：Collection Name
	 */
	 
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get：Collection Name
	 */
	public String getName() {
		return name;
	}
				
	
	/**
	 * Setting：Collection Pictures
	 */
	 
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/**
	 * Get：Collection Pictures
	 */
	public String getPicture() {
		return picture;
	}
				
	
	/**
	 * Setting：Type(1:Favorite,21:Like,22:Step)
	 */
	 
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Get：Type(1:Favorite,21:Like,22:Step)
	 */
	public String getType() {
		return type;
	}
				
	
	/**
	 * Setting：Recommendation Type
	 */
	 
	public void setInteltype(String inteltype) {
		this.inteltype = inteltype;
	}
	
	/**
	 * Get：Recommendation Type
	 */
	public String getInteltype() {
		return inteltype;
	}
			
}
