package com.entity.view;

import com.entity.MaijiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * Seller
 * Back-end return view entity helper class
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
@TableName("maijia")
public class MaijiaView  extends MaijiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MaijiaView(){
	}
 
 	public MaijiaView(MaijiaEntity maijiaEntity){
 	try {
			BeanUtils.copyProperties(this, maijiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
