package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.MaijiaEntity;
import com.entity.view.MaijiaView;

import com.service.MaijiaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * Seller
 * Back-end Interface
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
@RestController
@RequestMapping("/maijia")
public class MaijiaController {
    @Autowired
    private MaijiaService maijiaService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * login
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		MaijiaEntity u = maijiaService.selectOne(new EntityWrapper<MaijiaEntity>().eq("maijiaxuehao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("Incorrect account or password");
		}
		String token = tokenService.generateToken(u.getId(), username,"maijia",  "卖家" );
		return R.ok().put("token", token);
	}
	
	/**
     * Registration
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody MaijiaEntity maijia){
    	//ValidatorUtils.validateEntity(maijia);
    	MaijiaEntity u = maijiaService.selectOne(new EntityWrapper<MaijiaEntity>().eq("maijiaxuehao", maijia.getMaijiaxuehao()));
		if(u!=null) {
			return R.error("register user already exists");
		}
		Long uId = new Date().getTime();
		maijia.setId(uId);
        maijiaService.insert(maijia);
        return R.ok();
    }

	
	/**
	 * Logout
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("Exit succeeded");
	}
	
	/**
     * Get the user's session user information
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        MaijiaEntity u = maijiaService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * Password Reset
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	MaijiaEntity u = maijiaService.selectOne(new EntityWrapper<MaijiaEntity>().eq("maijiaxuehao", username));
    	if(u==null) {
    		return R.error("The account does not exist");
    	}
    	u.setMima("123456");
        maijiaService.updateById(u);
        return R.ok("Password has been reset to：123456");
    }


    /**
     * Backend List
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MaijiaEntity maijia, 
		HttpServletRequest request){

        EntityWrapper<MaijiaEntity> ew = new EntityWrapper<MaijiaEntity>();


		PageUtils page = maijiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, maijia), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * Front End List
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MaijiaEntity maijia, 
		HttpServletRequest request){
        EntityWrapper<MaijiaEntity> ew = new EntityWrapper<MaijiaEntity>();

		PageUtils page = maijiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, maijia), params), params));
        return R.ok().put("data", page);
    }

	/**
     * List
     */
    @RequestMapping("/lists")
    public R list( MaijiaEntity maijia){
       	EntityWrapper<MaijiaEntity> ew = new EntityWrapper<MaijiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( maijia, "maijia")); 
        return R.ok().put("data", maijiaService.selectListView(ew));
    }

	 /**
     *Search
     */
    @RequestMapping("/query")
    public R query(MaijiaEntity maijia){
        EntityWrapper< MaijiaEntity> ew = new EntityWrapper< MaijiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( maijia, "maijia")); 
		MaijiaView maijiaView =  maijiaService.selectView(ew);
		return R.ok("Successfully queried the seller").put("data", maijiaView);
    }
	
    /**
     * Back-end details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MaijiaEntity maijia = maijiaService.selectById(id);
        return R.ok().put("data", maijia);
    }

    /**
     * Front End Details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MaijiaEntity maijia = maijiaService.selectById(id);
        return R.ok().put("data", maijia);
    }
    



    /**
     * Back-end saving
     */
    @RequestMapping("/save")
    public R save(@RequestBody MaijiaEntity maijia, HttpServletRequest request){
    	maijia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(maijia);
    	MaijiaEntity u = maijiaService.selectOne(new EntityWrapper<MaijiaEntity>().eq("maijiaxuehao", maijia.getMaijiaxuehao()));
		if(u!=null) {
			return R.error("User already exists");
		}

		maijia.setId(new Date().getTime());
        maijiaService.insert(maijia);
        return R.ok();
    }
    
    /**
     * Front-end saving
     */
    @RequestMapping("/add")
    public R add(@RequestBody MaijiaEntity maijia, HttpServletRequest request){
    	maijia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(maijia);
    	MaijiaEntity u = maijiaService.selectOne(new EntityWrapper<MaijiaEntity>().eq("maijiaxuehao", maijia.getMaijiaxuehao()));
		if(u!=null) {
			return R.error("User already exists");
		}

		maijia.setId(new Date().getTime());
        maijiaService.insert(maijia);
        return R.ok();
    }


    /**
     * Modify
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MaijiaEntity maijia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(maijia);
        maijiaService.updateById(maijia);//Update all
        return R.ok();
    }
    

    /**
     * Delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        maijiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * Reminder Interface
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<MaijiaEntity> wrapper = new EntityWrapper<MaijiaEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = maijiaService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	








}
