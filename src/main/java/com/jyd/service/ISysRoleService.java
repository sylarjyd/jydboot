package com.jyd.service;

import com.jyd.entity.SysRole;
import com.jyd.vo.SysRoleVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 角色 服务类
 *
 * @author 
 * @since 2023-12-01
 */
public interface ISysRoleService extends IService<SysRole> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param sysRole
	 * @return
	 */
	IPage<SysRoleVO> selectSysRolePage(IPage<SysRoleVO> page, SysRoleVO sysRole);

}
