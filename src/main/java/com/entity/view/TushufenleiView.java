package com.entity.view;

import com.entity.TushufenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * Book classification
 * Back-end return view entity helper class

 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
@TableName("tushufenlei")
public class TushufenleiView  extends TushufenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TushufenleiView(){
	}
 
 	public TushufenleiView(TushufenleiEntity tushufenleiEntity){
 	try {
			BeanUtils.copyProperties(this, tushufenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
