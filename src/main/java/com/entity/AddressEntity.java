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
 * Address
 * Database generic operation entity class (general add, delete, change, check)
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
@TableName("address")
public class AddressEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public AddressEntity() {
		
	}
	
	public AddressEntity(T t) {
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
	 * address
	 */
					
	private String address;
	
	/**
	 * Receiver
	 */
					
	private String name;
	
	/**
	 * tel
	 */
					
	private String phone;
	
	/**
	 * Default address or not [Yes/No]
	 */
					
	private String isdefault;
	
	
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
	 * Settings：User id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * Access：User id
	 */
	public Long getUserid() {
		return userid;
	}
	/**
	 * Settings：address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * Access:adress
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * Setting: Receiver
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Access:Receiver
	 */
	public String getName() {
		return name;
	}
	/**
	 * Settings: Telephone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * Access: Telephone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * Setting: whether to default address [Yes/No]
	 */
	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}
	/**
	 * Get: whether default address [Yes/No]
	 */
	public String getIsdefault() {
		return isdefault;
	}

}
