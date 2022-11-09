package com.entity.vo;

import com.entity.DiscusstushuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * Book Information Review Form
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
public class DiscusstushuxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * User id
	 */
	
	private Long userid;
		
	/**
	 * Username
	 */
	
	private String nickname;
		
	/**
	 * Comments
	 */
	
	private String content;
		
	/**
	 * Reply Content
	 */
	
	private String reply;
				
	
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
	 * Setting：Username
	 */
	 
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/**
	 * Get：Username
	 */
	public String getNickname() {
		return nickname;
	}
				
	
	/**
	 * Setting：Comments
	 */
	 
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Get：Comments
	 */
	public String getContent() {
		return content;
	}
				
	
	/**
	 * Setting：Reply Content
	 */
	 
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	/**
	 * Get：Reply Content
	 */
	public String getReply() {
		return reply;
	}
			
}
