package com.jyd.service;

import com.jyd.entity.SysDept;
import com.jyd.vo.SysDeptVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 部门 服务类
 *
 * @author 
 * @since 2023-12-01
 */
public interface ISysDeptService extends IService<SysDept> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param sysDept
	 * @return
	 */
	IPage<SysDeptVO> selectSysDeptPage(IPage<SysDeptVO> page, SysDeptVO sysDept);

}
