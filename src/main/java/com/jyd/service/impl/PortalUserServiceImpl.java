package com.jyd.service.impl;

import com.jyd.entity.PortalUser;
import com.jyd.vo.PortalUserVO;
import com.jyd.mapper.PortalUserMapper;
import com.jyd.service.IPortalUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;

/**
 * 门户用户 服务实现类
 *
 * @author
 * @since 2023-07-19
 */
@Service
public class PortalUserServiceImpl extends ServiceImpl<PortalUserMapper, PortalUser> implements IPortalUserService {

	@Resource
	private PortalUserMapper portalUserMapper;

	@Override
	public IPage<PortalUserVO> selectPortalUserPage(IPage<PortalUserVO> page, PortalUserVO portalUser) {
		return page.setRecords(portalUserMapper.selectPortalUserPage(page, portalUser));
	}

}
