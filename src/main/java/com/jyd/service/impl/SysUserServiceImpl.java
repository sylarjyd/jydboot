package com.jyd.service.impl;

import com.jyd.entity.SysUser;
import com.jyd.vo.SysUserVO;
import com.jyd.mapper.SysUserMapper;
import com.jyd.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 系统用户 服务实现类
 *
 * @author 
 * @since 2023-12-01
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

	@Override
	public IPage<SysUserVO> selectSysUserPage(IPage<SysUserVO> page, SysUserVO sysUser) {
		return page.setRecords(baseMapper.selectSysUserPage(page, sysUser));
	}

}
