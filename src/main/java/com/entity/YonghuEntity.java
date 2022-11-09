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
 * User
 * Database general operation entity class (general add, delete, change, check)
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
@TableName("yonghu")
public class YonghuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YonghuEntity() {
		
	}
	
	public YonghuEntity(T t) {
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
	 * Student ID
	 */
					
	private String xuehao;
	
	/**
	 * Password
	 */
					
	private String mima;
	
	/**
	 * Name
	 */
					
	private String xingming;
	
	/**
	 * Gender
	 */
					
	private String xingbie;
	
	/**
	 * Photo
	 */
					
	private String touxiang;
	
	/**
	 * Mobile
	 */
					
	private String shouji;
	
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
	 * Setting：Student ID
	 */
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	/**
	 * Get：Student ID
	 */
	public String getXuehao() {
		return xuehao;
	}
	/**
	 * Setting：Password
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
	 * Setting：Name
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * Get：Name
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * Setting：Gender
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
	 * Setting：Photo
	 */
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	/**
	 * Get：Photo
	 */
	public String getTouxiang() {
		return touxiang;
	}
	/**
	 * Setting：Mobile
	 */
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	/**
	 * Get：Mobile
	 */
	public String getShouji() {
		return shouji;
	}
	/**
	 * Setting：Balance
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
