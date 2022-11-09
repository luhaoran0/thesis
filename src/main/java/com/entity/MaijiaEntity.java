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
 * Sellers
 * Database general operation entity class (general add, delete, change, check)
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
@TableName("maijia")
public class MaijiaEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public MaijiaEntity() {
		
	}
	
	public MaijiaEntity(T t) {
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
	 * Seller's school number
	 */
					
	private String maijiaxuehao;
	
	/**
	 * Password
	 */
					
	private String mima;
	
	/**
	 * Seller's name
	 */
					
	private String maijiaxingming;
	
	/**
	 * Gender
	 */
					
	private String xingbie;
	
	/**
	 * Photo
	 */
					
	private String zhaopian;
	
	/**
	 * Contact number
	 */
					
	private String lianxidianhua;
	
	/**
	 * Balance
	 */
					
	private Float money;
	
	
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
	 * Settings：Seller's school number
	 */
	public void setMaijiaxuehao(String maijiaxuehao) {
		this.maijiaxuehao = maijiaxuehao;
	}
	/**
	 * Get：Seller's school number
	 */
	public String getMaijiaxuehao() {
		return maijiaxuehao;
	}
	/**
	 * Settings：Password
	 */
	public void setMima(String mima) {
		this.mima = mima;
	}
	/**
	 * Get：Password
	 */
	public String getMima() {
		return mima;
	}
	/**
	 * Settings：Seller's name
	 */
	public void setMaijiaxingming(String maijiaxingming) {
		this.maijiaxingming = maijiaxingming;
	}
	/**
	 * Get：Seller's name
	 */
	public String getMaijiaxingming() {
		return maijiaxingming;
	}
	/**
	 * Settings：Gender
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * Get：Gender
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * Settings：Photo
	 */
	public void setZhaopian(String zhaopian) {
		this.zhaopian = zhaopian;
	}
	/**
	 * Get：Photo
	 */
	public String getZhaopian() {
		return zhaopian;
	}
	/**
	 * Settings：Contact number
	 */
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	/**
	 * Get：Contact number
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
	/**
	 * Settings：Balance
	 */
	public void setMoney(Float money) {
		this.money = money;
	}
	/**
	 * Get：Balance
	 */
	public Float getMoney() {
		return money;
	}

}
