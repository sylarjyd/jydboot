package com.jyd.service.impl;

import com.jyd.entity.District;
import com.jyd.vo.DistrictVO;
import com.jyd.mapper.DistrictMapper;
import com.jyd.service.IDistrictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 区划 服务实现类
 *
 * @author 
 * @since 2023-12-01
 */
@Service
public class DistrictServiceImpl extends ServiceImpl<DistrictMapper, District> implements IDistrictService {

	@Override
	public IPage<DistrictVO> selectDistrictPage(IPage<DistrictVO> page, DistrictVO district) {
		return page.setRecords(baseMapper.selectDistrictPage(page, district));
	}

}
