package com.entity.vo;

import com.entity.LiaotianjiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 聊天记录
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
public class LiaotianjiluVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 卖家学号
	 */
	
	private String maijiaxuehao;
		
	/**
	 * 内容信息
	 */
	
	private String neirongxinxi;
		
	/**
	 * 学号
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
	 * 设置：卖家学号
	 */
	 
	public void setMaijiaxuehao(String maijiaxuehao) {
		this.maijiaxuehao = maijiaxuehao;
	}
	
	/**
	 * 获取：卖家学号
	 */
	public String getMaijiaxuehao() {
		return maijiaxuehao;
	}
				
	
	/**
	 * 设置：内容信息
	 */
	 
	public void setNeirongxinxi(String neirongxinxi) {
		this.neirongxinxi = neirongxinxi;
	}
	
	/**
	 * 获取：内容信息
	 */
	public String getNeirongxinxi() {
		return neirongxinxi;
	}
				
	
	/**
	 * 设置：学号
	 */
	 
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
			
}
