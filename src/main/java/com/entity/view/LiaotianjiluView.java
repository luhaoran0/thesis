package com.entity.view;

import com.entity.LiaotianjiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * Chat history
 * Back-end return view entity helper class
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
@TableName("liaotianjilu")
public class LiaotianjiluView  extends LiaotianjiluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LiaotianjiluView(){
	}
 
 	public LiaotianjiluView(LiaotianjiluEntity liaotianjiluEntity){
 	try {
			BeanUtils.copyProperties(this, liaotianjiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
