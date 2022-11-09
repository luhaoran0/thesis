package com.entity.view;

import com.entity.TushuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * Book Information
 * Back-end return view entity helper class
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
@TableName("tushuxinxi")
public class TushuxinxiView  extends TushuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TushuxinxiView(){
	}
 
 	public TushuxinxiView(TushuxinxiEntity tushuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, tushuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
