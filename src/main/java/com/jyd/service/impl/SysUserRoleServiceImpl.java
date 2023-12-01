package com.jyd.service.impl;

import com.jyd.entity.SysUserRole;
import com.jyd.vo.SysUserRoleVO;
import com.jyd.mapper.SysUserRoleMapper;
import com.jyd.service.ISysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 用户-角色 服务实现类
 *
 * @author 
 * @since 2023-12-01
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

	@Override
	public IPage<SysUserRoleVO> selectSysUserRolePage(IPage<SysUserRoleVO> page, SysUserRoleVO sysUserRole) {
		return page.setRecords(baseMapper.selectSysUserRolePage(page, sysUserRole));
	}

}
