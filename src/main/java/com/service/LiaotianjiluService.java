package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LiaotianjiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LiaotianjiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LiaotianjiluView;


/**
 * 聊天记录
 *
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
public interface LiaotianjiluService extends IService<LiaotianjiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LiaotianjiluVO> selectListVO(Wrapper<LiaotianjiluEntity> wrapper);
   	
   	LiaotianjiluVO selectVO(@Param("ew") Wrapper<LiaotianjiluEntity> wrapper);
   	
   	List<LiaotianjiluView> selectListView(Wrapper<LiaotianjiluEntity> wrapper);
   	
   	LiaotianjiluView selectView(@Param("ew") Wrapper<LiaotianjiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LiaotianjiluEntity> wrapper);
   	

}

