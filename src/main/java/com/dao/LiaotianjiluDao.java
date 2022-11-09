package com.dao;

import com.entity.LiaotianjiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LiaotianjiluVO;
import com.entity.view.LiaotianjiluView;


/**
 * Chat transcript
 * 
 * @author 
 * @email 
 * @date 2022-09-09 11:45:05
 */
public interface LiaotianjiluDao extends BaseMapper<LiaotianjiluEntity> {
	
	List<LiaotianjiluVO> selectListVO(@Param("ew") Wrapper<LiaotianjiluEntity> wrapper);
	
	LiaotianjiluVO selectVO(@Param("ew") Wrapper<LiaotianjiluEntity> wrapper);
	
	List<LiaotianjiluView> selectListView(@Param("ew") Wrapper<LiaotianjiluEntity> wrapper);

	List<LiaotianjiluView> selectListView(Pagination page,@Param("ew") Wrapper<LiaotianjiluEntity> wrapper);
	
	LiaotianjiluView selectView(@Param("ew") Wrapper<LiaotianjiluEntity> wrapper);
	

}
