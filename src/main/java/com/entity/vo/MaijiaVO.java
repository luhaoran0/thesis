package com.entity.vo;

import com.entity.MaijiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * Seller
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
public class MaijiaVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
	 * Contact Number
	 */
	
	private String lianxidianhua;
		
	/**
	 * Balance
	 */
	
	private Float money;
				
	
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
	 * Setting：Seller's name
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
	 * Setting：Contact Number
	 */
	 
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	
	/**
	 * Get：Contact Number
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
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
