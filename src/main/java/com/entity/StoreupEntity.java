package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * Collection Table
 * Database general operation entity class (general add, delete, change, check)
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
@TableName("storeup")
public class StoreupEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public StoreupEntity() {
		
	}
	
	public StoreupEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Primary key id
	 */
	@TableId
	private Long id;
	/**
	 * User id
	 */
					
	private Long userid;
	
	/**
	 * Collection id
	 */
					
	private Long refid;
	
	/**
	 *Table Name
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Setting：User id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * Get：User id
	 */
	public Long getUserid() {
		return userid;
	}
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
