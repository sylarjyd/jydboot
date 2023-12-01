package com.jyd.service;

import com.jyd.entity.District;
import com.jyd.vo.DistrictVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 区划 服务类
 *
 * @author 
 * @since 2023-12-01
 */
public interface IDistrictService extends IService<District> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param district
	 * @return
	 */
	IPage<DistrictVO> selectDistrictPage(IPage<DistrictVO> page, DistrictVO district);

}
