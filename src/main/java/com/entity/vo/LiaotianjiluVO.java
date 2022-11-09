package com.entity.vo;

import com.entity.LiaotianjiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * Chat history
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
public class LiaotianjiluVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * Seller's school number
	 */
	
	private String maijiaxuehao;
		
	/**
	 * Content Information
	 */
	
	private String neirongxinxi;
		
	/**
	 * Student ID
	 */
	
	private String xuehao;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
	/**
	 * Setting：Seller's school number
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
	 * Setting：Content Information
	 */
	 
	public void setNeirongxinxi(String neirongxinxi) {
		this.neirongxinxi = neirongxinxi;
	}
	
	/**
	 * Get：Content Information
	 */
	public String getNeirongxinxi() {
		return neirongxinxi;
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
	 * Setting：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * Get：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * Setting：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * Get：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
			
}
