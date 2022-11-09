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
 * Book Information
 * Database general operation entity class (general add, delete, change, check)
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
@TableName("tushuxinxi")
public class TushuxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TushuxinxiEntity() {
		
	}
	
	public TushuxinxiEntity(T t) {
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
	 * Book Title
	 */
					
	private String tushumingcheng;
	
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
	 * Setting：Book Title
	 */
	public void setTushumingcheng(String tushumingcheng) {
		this.tushumingcheng = tushumingcheng;
	}
	/**
	 * Get：Book Title
	 */
	public String getTushumingcheng() {
		return tushumingcheng;
	}
	/**
	 * Setting：Book classification
	 */
	public void setTushufenlei(String tushufenlei) {
		this.tushufenlei = tushufenlei;
	}
	/**
	 *Get：Book classification
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
