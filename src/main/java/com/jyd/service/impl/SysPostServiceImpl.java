package com.jyd.service.impl;

import com.jyd.entity.SysPost;
import com.jyd.vo.SysPostVO;
import com.jyd.mapper.SysPostMapper;
import com.jyd.service.ISysPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 岗位 服务实现类
 *
 * @author 
 * @since 2023-12-01
 */
@Service
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost> implements ISysPostService {

	@Override
	public IPage<SysPostVO> selectSysPostPage(IPage<SysPostVO> page, SysPostVO sysPost) {
		return page.setRecords(baseMapper.selectSysPostPage(page, sysPost));
	}

}
