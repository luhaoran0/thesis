package com.entity.view;

import com.entity.DiscusstushuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * Book Information Review Form
 * Back-end return view entity helper class
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
@TableName("discusstushuxinxi")
public class DiscusstushuxinxiView  extends DiscusstushuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusstushuxinxiView(){
	}
 
 	public DiscusstushuxinxiView(DiscusstushuxinxiEntity discusstushuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discusstushuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
