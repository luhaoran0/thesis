package com.entity.vo;

import com.entity.AddressEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * Address
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
public class AddressVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * Address
	 */
	
	private String address;
		
	/**
	 * Receiver
	 */
	
	private String name;
		
	/**
	 * Telephone
	 */
	
	private String phone;
		
	/**
	 * Is the default address [Yes/No]
	 */
	
	private String isdefault;
				
	
	/**
	 * Setting：Address
	 */
	 
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Get：Address
	 */
	public String getAddress() {
		return address;
	}
				
	
	/**
	 * Setting：Receiver
	 */
	 
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get：Receiver
	 */
	public String getName() {
		return name;
	}
				
	
	/**
	 * Setting：Telephone
	 */
	 
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Get：Telephone
	 */
	public String getPhone() {
		return phone;
	}
				
	
	/**
	 * Setting：Is the default address [Yes/No]
	 */
	 
	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}
	
	/**
	 * Get：Is the default address [Yes/No]
	 */
	public String getIsdefault() {
		return isdefault;
	}
			
}
