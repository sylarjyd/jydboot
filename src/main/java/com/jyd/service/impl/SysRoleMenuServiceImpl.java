package com.jyd.service.impl;

import com.jyd.entity.SysRoleMenu;
import com.jyd.vo.SysRoleMenuVO;
import com.jyd.mapper.SysRoleMenuMapper;
import com.jyd.service.ISysRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 角色-权限 服务实现类
 *
 * @author 
 * @since 2023-12-01
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {

	@Override
	public IPage<SysRoleMenuVO> selectSysRoleMenuPage(IPage<SysRoleMenuVO> page, SysRoleMenuVO sysRoleMenu) {
		return page.setRecords(baseMapper.selectSysRoleMenuPage(page, sysRoleMenu));
	}

}
