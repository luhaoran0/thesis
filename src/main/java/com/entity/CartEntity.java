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
 * Shopping cart table
 * Database generic operation entity class (general add, delete, change, check)
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
@TableName("cart")
public class CartEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CartEntity() {
		
	}
	
	public CartEntity(T t) {
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
	 * tablename
	 */
					
	private String tablename;
	
	/**
	 * userid
	 */
					
	private Long userid;
	
	/**
	 * goodid
	 */
					
	private Long goodid;
	
	/**
	 * goodname
	 */
					
	private String goodname;
	
	/**
	 * picture
	 */
					
	private String picture;
	
	/**
	 * buynumber
	 */
					
	private Integer buynumber;
	
	/**
	 * price
	 */
					
	private Float price;
	
	/**
	 * discountprice
	 */
					
	private Float discountprice;
	
	/**
	 * Name of merchant
	 */
					
	private String maijiaxuehao;
	
	
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
	 * Settings: Product table name
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	/**
	 * Get: Product List Name
	 */
	public String getTablename() {
		return tablename;
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
	 * Settings: product id
	 */
	public void setGoodid(Long goodid) {
		this.goodid = goodid;
	}
	/**
	 * Get: product id
	 */
	public Long getGoodid() {
		return goodid;
	}
	/**
	 * Settings: Product name
	 */
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	/**
	 * Get: Product name
	 */
	public String getGoodname() {
		return goodname;
	}
	/**
	 * Settings: Pictures
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	/**
	 * Get: Pictures
	 */
	public String getPicture() {
		return picture;
	}
	/**
	 * Settings: Number of purchases
	 */
	public void setBuynumber(Integer buynumber) {
		this.buynumber = buynumber;
	}
	/**
	 * Access: Number of purchases
	 */
	public Integer getBuynumber() {
		return buynumber;
	}
	/**
	 * Settings: price
	 */
	public void setPrice(Float price) {
		this.price = price;
	}
	/**
	 * Get: price
	 */
	public Float getPrice() {
		return price;
	}
	/**
	 * Setting: Member price
	 */
	public void setDiscountprice(Float discountprice) {
		this.discountprice = discountprice;
	}
	/**
	 * Get: Member price
	 */
	public Float getDiscountprice() {
		return discountprice;
	}
	/**
	 * Settings: Merchant name
	 */
	public void setMaijiaxuehao(String maijiaxuehao) {
		this.maijiaxuehao = maijiaxuehao;
	}
	/**
	 * Get: Merchant Name
	 */
	public String getMaijiaxuehao() {
		return maijiaxuehao;
	}

}
