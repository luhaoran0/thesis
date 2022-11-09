package com.entity.model;

import com.entity.TushuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * Book Information
 * Entity class for receiving passed parameters
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
public class TushuxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * Book classification
	 */
	
	private String tushufenlei;
		
	/**
	 * Book Cover
	 */
	
	private String tushufengmian;
		
	/**
	 * Book Author
	 */
	
	private String tushuzuozhe;
		
	/**
	 * Book quality
	 */
	
	private String tushuchengse;
		
	/**
	 * Seller's school number
	 */
	
	private String maijiaxuehao;
		
	/**
	 * Seller's name
	 */
	
	private String maijiaxingming;
		
	/**
	 * Contact Number
	 */
	
	private String lianxidianhua;
		
	/**
	 * Book Details
	 */
	
	private String tushuxiangqing;
		
	/**
	 * Order limit
	 */
	
	private Integer onelimittimes;
		
	/**
	 * Inventories
	 */
	
	private Integer alllimittimes;
		
	/**
	 * Price
	 */
	
	private Float price;
				
	
	/**
	 * Setting：Book classification
	 */
	 
	public void setTushufenlei(String tushufenlei) {
		this.tushufenlei = tushufenlei;
	}
	
	/**
	 * Get：Book classification
	 */
	public String getTushufenlei() {
		return tushufenlei;
	}
				
	
	/**
	 * Setting：Book Cover
	 */
	 
	public void setTushufengmian(String tushufengmian) {
		this.tushufengmian = tushufengmian;
	}
	
	/**
	 * Get：Book Cover
	 */
	public String getTushufengmian() {
		return tushufengmian;
	}
				
	
	/**
	 * Setting：Book Author
	 */
	 
	public void setTushuzuozhe(String tushuzuozhe) {
		this.tushuzuozhe = tushuzuozhe;
	}
	
	/**
	 * Get：Book Author
	 */
	public String getTushuzuozhe() {
		return tushuzuozhe;
	}
				
	
	/**
	 * Setting：Book quality
	 */
	 
	public void setTushuchengse(String tushuchengse) {
		this.tushuchengse = tushuchengse;
	}
	
	/**
	 * Get：Book quality
	 */
	public String getTushuchengse() {
		return tushuchengse;
	}
				
	
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
	 * Setting：Book Details
	 */
	 
	public void setTushuxiangqing(String tushuxiangqing) {
		this.tushuxiangqing = tushuxiangqing;
	}
	
	/**
	 * Get：Book Details
	 */
	public String getTushuxiangqing() {
		return tushuxiangqing;
	}
				
	
	/**
	 * Setting：Order limit
	 */
	 
	public void setOnelimittimes(Integer onelimittimes) {
		this.onelimittimes = onelimittimes;
	}
	
	/**
	 * Get：Order limit
	 */
	public Integer getOnelimittimes() {
		return onelimittimes;
	}
				
	
	/**
	 * Setting：Inventories
	 */
	 
	public void setAlllimittimes(Integer alllimittimes) {
		this.alllimittimes = alllimittimes;
	}
	
	/**
	 * Get：Inventories
	 */
	public Integer getAlllimittimes() {
		return alllimittimes;
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
			
}
