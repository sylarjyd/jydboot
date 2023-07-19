package com.jyd.service;

import com.jyd.entity.PortalUser;
import com.jyd.vo.PortalUserVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 门户用户 服务类
 *
 * @author 
 * @since 2023-07-19
 */
public interface IPortalUserService extends IService<PortalUser> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param portalUser
	 * @return
	 */
	IPage<PortalUserVO> selectPortalUserPage(IPage<PortalUserVO> page, PortalUserVO portalUser);

}
