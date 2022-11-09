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
 * Chat history
 * Database generic operation entity class (general add, delete, change, check)
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
@TableName("liaotianjilu")
public class LiaotianjiluEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LiaotianjiluEntity() {
		
	}
	
	public LiaotianjiluEntity(T t) {
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
	 * Book title
	 */
					
	private String tushumingcheng;
	
	/**
	 * Seller's school number
	 */
					
	private String maijiaxuehao;
	
	/**
	 * Content information
	 */
					
	private String neirongxinxi;
	
	/**
	 * Student ID
	 */
					
	private String xuehao;
	
	/**
	 * Whether to review
	 */
					
	private String sfsh;
	
	/**
	 * Review Reply
	 */
					
	private String shhf;
	
	
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
	 * Settings: Book name
	 */
	public void setTushumingcheng(String tushumingcheng) {
		this.tushumingcheng = tushumingcheng;
	}
	/**
	 * Get: Book title
	 */
	public String getTushumingcheng() {
		return tushumingcheng;
	}
	/**
	 * Setting: Seller's school number
	 */
	public void setMaijiaxuehao(String maijiaxuehao) {
		this.maijiaxuehao = maijiaxuehao;
	}
	/**
	 * Get: seller's school number
	 */
	public String getMaijiaxuehao() {
		return maijiaxuehao;
	}
	/**
	 * Settings: Content information
	 */
	public void setNeirongxinxi(String neirongxinxi) {
		this.neirongxinxi = neirongxinxi;
	}
	/**
	 * Get: content information
	 */
	public String getNeirongxinxi() {
		return neirongxinxi;
	}
	/**
	 * Setting: Student ID
	 */
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	/**
	 * Get: Student ID
	 */
	public String getXuehao() {
		return xuehao;
	}
	/**
	 * Settings: Whether to review
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * Get: whether to review
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * Settings: Review responses
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * Get: Review Responses
	 */
	public String getShhf() {
		return shhf;
	}

}
