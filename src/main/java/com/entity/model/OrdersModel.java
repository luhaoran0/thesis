package com.entity.model;

import com.entity.OrdersEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * Orders
 * Entity class for receiving passed parameters
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
public class OrdersModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * Product List Name
	 */
	
	private String tablename;
		
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
	 * Product pictures
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
	 * Discount Price
	 */
	
	private Float discountprice;
		
	/**
	 * Total Price
	 */
	
	private Float total;
		
	/**
	 * Total discounted price
	 */
	
	private Float discounttotal;
		
	/**
	 * Payment Type
	 */
	
	private Integer type;
		
	/**
	 * Status
	 */
	
	private String status;
		
	/**
	 * Address
	 */
	
	private String address;
		
	/**
	 * Telephone
	 */
	
	private String tel;
		
	/**
	 * Receiver
	 */
	
	private String consignee;
		
	/**
	 * Remarks
	 */
	
	private String remark;
		
	/**
	 * Express delivery
	 */
	
	private String logistics;
		
	/**
	 * Merchant Name
	 */
	
	private String maijiaxuehao;
				
	
	/**
	 * Setting：Product List Name
	 */
	 
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	
	/**
	 * Get：Product List Name
	 */
	public String getTablename() {
		return tablename;
	}
				
	
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
	 * Setting：Product pictures
	 */
	 
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/**
	 * Get：Product pictures
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
	 * Setting：Discount Price
	 */
	 
	public void setDiscountprice(Float discountprice) {
		this.discountprice = discountprice;
	}
	
	/**
	 * Get：Discount Price
	 */
	public Float getDiscountprice() {
		return discountprice;
	}
				
	
	/**
	 * Setting：Total Price
	 */
	 
	public void setTotal(Float total) {
		this.total = total;
	}
	
	/**
	 * Get：Total Price
	 */
	public Float getTotal() {
		return total;
	}
				
	
	/**
	 * Setting：Total discounted price
	 */
	 
	public void setDiscounttotal(Float discounttotal) {
		this.discounttotal = discounttotal;
	}
	
	/**
	 * Get：Total discounted price
	 */
	public Float getDiscounttotal() {
		return discounttotal;
	}
				
	
	/**
	 * Setting：Payment Type
	 */
	 
	public void setType(Integer type) {
		this.type = type;
	}
	
	/**
	 * Get：Payment Type
	 */
	public Integer getType() {
		return type;
	}
				
	
	/**
	 * Setting：Status
	 */
	 
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Get：Status
	 */
	public String getStatus() {
		return status;
	}
				
	
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
	 * Setting：Telephone
	 */
	 
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	/**
	 * Get：Telephone
	 */
	public String getTel() {
		return tel;
	}
				
	
	/**
	 * Setting：Receiver
	 */
	 
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	
	/**
	 * Get：Receiver
	 */
	public String getConsignee() {
		return consignee;
	}
				
	
	/**
	 * Setting：Remarks
	 */
	 
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Get：Remarks
	 */
	public String getRemark() {
		return remark;
	}
				
	
	/**
	 * Setting：Express delivery
	 */
	 
	public void setLogistics(String logistics) {
		this.logistics = logistics;
	}
	
	/**
	 * Get：Express delivery
	 */
	public String getLogistics() {
		return logistics;
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
