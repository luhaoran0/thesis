package com.entity.model;

import com.entity.YonghuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * User
 * Entity class for receiving passed parameters
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
public class YonghuModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
