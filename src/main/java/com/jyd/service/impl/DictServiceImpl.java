package com.jyd.service.impl;

import com.jyd.entity.Dict;
import com.jyd.vo.DictVO;
import com.jyd.mapper.DictMapper;
import com.jyd.service.IDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 字典 服务实现类
 *
 * @author 
 * @since 2023-12-01
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements IDictService {

	@Override
	public IPage<DictVO> selectDictPage(IPage<DictVO> page, DictVO dict) {
		return page.setRecords(baseMapper.selectDictPage(page, dict));
	}

}
