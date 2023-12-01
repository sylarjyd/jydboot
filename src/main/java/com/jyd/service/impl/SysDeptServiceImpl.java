package com.jyd.service.impl;

import com.jyd.entity.SysDept;
import com.jyd.vo.SysDeptVO;
import com.jyd.mapper.SysDeptMapper;
import com.jyd.service.ISysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 部门 服务实现类
 *
 * @author 
 * @since 2023-12-01
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {

	@Override
	public IPage<SysDeptVO> selectSysDeptPage(IPage<SysDeptVO> page, SysDeptVO sysDept) {
		return page.setRecords(baseMapper.selectSysDeptPage(page, sysDept));
	}

}
