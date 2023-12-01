package com.jyd.service.impl;

import com.jyd.entity.SysRole;
import com.jyd.vo.SysRoleVO;
import com.jyd.mapper.SysRoleMapper;
import com.jyd.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 角色 服务实现类
 *
 * @author 
 * @since 2023-12-01
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

	@Override
	public IPage<SysRoleVO> selectSysRolePage(IPage<SysRoleVO> page, SysRoleVO sysRole) {
		return page.setRecords(baseMapper.selectSysRolePage(page, sysRole));
	}

}
