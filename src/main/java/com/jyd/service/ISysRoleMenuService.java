package com.jyd.service;

import com.jyd.entity.SysRoleMenu;
import com.jyd.vo.SysRoleMenuVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 角色-权限 服务类
 *
 * @author 
 * @since 2023-12-01
 */
public interface ISysRoleMenuService extends IService<SysRoleMenu> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param sysRoleMenu
	 * @return
	 */
	IPage<SysRoleMenuVO> selectSysRoleMenuPage(IPage<SysRoleMenuVO> page, SysRoleMenuVO sysRoleMenu);

}
