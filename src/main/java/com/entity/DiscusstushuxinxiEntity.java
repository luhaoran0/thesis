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
 * Book Info Review Form
 * Database generic operation entity class (general add, delete, change, check）
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
@TableName("discusstushuxinxi")
public class DiscusstushuxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DiscusstushuxinxiEntity() {
		
	}
	
	public DiscusstushuxinxiEntity(T t) {
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
	 * Related table id
	 */
					
	private Long refid;
	
	/**
	 * User id
	 */
					
	private Long userid;
	
	/**
	 * Username
	 */
					
	private String nickname;
	
	/**
	 * Comments
	 */
					
	private String content;
	
	/**
	 * Response content
	 */
					
	private String reply;
	
	
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
	 * Set: associated table id
	 */
	public void setRefid(Long refid) {
		this.refid = refid;
	}
	/**
	 * Get: associated table id
	 */
	public Long getRefid() {
		return refid;
	}
	/**
	 * Settings: user id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * Get: user id
	 */
	public Long getUserid() {
		return userid;
	}
	/**
	 * Settings: Username
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * Get: Username
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * Settings: Comment content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * Access: Review content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * Settings: Reply content
	 */
	public void setReply(String reply) {
		this.reply = reply;
	}
	/**
	 * Access: Reply to content
	 */
	public String getReply() {
		return reply;
	}

}
