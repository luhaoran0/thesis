package com.entity.vo;

import com.entity.CartEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * Shopping cart table
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
public class CartVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * User id
	 */
	
	private Long userid;
		
	/**
	 * Product id
	 */
	
	private Long goodid;
		
	/**
	 * Product Name
	 */
	
	private String goodname;
		
	/**
	 * Pictures
	 */
	
	private String picture;
		
	/**
	 * Number of purchases
	 */
	
	private Integer buynumber;
		
	/**
	 * Price
	 */
	
	private Float price;
		
	/**
	 * Member price
	 */
	
	private Float discountprice;
		
	/**
	 * Merchant Name
	 */
	
	private String maijiaxuehao;
				
	
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
	 * Setting：Product id
	 */
	 
	public void setGoodid(Long goodid) {
		this.goodid = goodid;
	}
	
	/**
	 * Get：Product id
	 */
	public Long getGoodid() {
		return goodid;
	}
				
	
	/**
	 * Setting：Product Name
	 */
	 
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	
	/**
	 * Get：Product Name
	 */
	public String getGoodname() {
		return goodname;
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
	 * Setting：Number of purchases
	 */
	 
	public void setBuynumber(Integer buynumber) {
		this.buynumber = buynumber;
	}
	
	/**
	 * Get：Number of purchases
	 */
	public Integer getBuynumber() {
		return buynumber;
	}
				
	
	/**
	 * Setting：Price
	 */
	 
	public void setPrice(Float price) {
		this.price = price;
	}
	
	/**
	 * Get：Price
	 */
	public Float getPrice() {
		return price;
	}
				
	
	/**
	 * Setting：Member price
	 */
	 
	public void setDiscountprice(Float discountprice) {
		this.discountprice = discountprice;
	}
	
	/**
	 * Get：Member price
	 */
	public Float getDiscountprice() {
		return discountprice;
	}
				
	
	/**
	 * Setting：Merchant Name
	 */
	 
	public void setMaijiaxuehao(String maijiaxuehao) {
		this.maijiaxuehao = maijiaxuehao;
	}
	
	/**
	 * Get：Merchant Name
	 */
	public String getMaijiaxuehao() {
		return maijiaxuehao;
	}
			
}
