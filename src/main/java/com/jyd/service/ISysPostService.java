package com.jyd.service;

import com.jyd.entity.SysPost;
import com.jyd.vo.SysPostVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 岗位 服务类
 *
 * @author 
 * @since 2023-12-01
 */
public interface ISysPostService extends IService<SysPost> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param sysPost
	 * @return
	 */
	IPage<SysPostVO> selectSysPostPage(IPage<SysPostVO> page, SysPostVO sysPost);

}
