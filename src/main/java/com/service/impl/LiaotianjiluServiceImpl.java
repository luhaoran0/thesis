package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.LiaotianjiluDao;
import com.entity.LiaotianjiluEntity;
import com.service.LiaotianjiluService;
import com.entity.vo.LiaotianjiluVO;
import com.entity.view.LiaotianjiluView;

@Service("liaotianjiluService")
public class LiaotianjiluServiceImpl extends ServiceImpl<LiaotianjiluDao, LiaotianjiluEntity> implements LiaotianjiluService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LiaotianjiluEntity> page = this.selectPage(
                new Query<LiaotianjiluEntity>(params).getPage(),
                new EntityWrapper<LiaotianjiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LiaotianjiluEntity> wrapper) {
		  Page<LiaotianjiluView> page =new Query<LiaotianjiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LiaotianjiluVO> selectListVO(Wrapper<LiaotianjiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LiaotianjiluVO selectVO(Wrapper<LiaotianjiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LiaotianjiluView> selectListView(Wrapper<LiaotianjiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LiaotianjiluView selectView(Wrapper<LiaotianjiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
