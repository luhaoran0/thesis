package com.entity.view;

import com.entity.CartEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * Shopping cart table
 * Back-end return view entity helper class
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
@TableName("cart")
public class CartView  extends CartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CartView(){
	}
 
 	public CartView(CartEntity cartEntity){
 	try {
			BeanUtils.copyProperties(this, cartEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
