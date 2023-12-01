package com.jyd.service;

import com.jyd.entity.SysUserRole;
import com.jyd.vo.SysUserRoleVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 用户-角色 服务类
 *
 * @author 
 * @since 2023-12-01
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param sysUserRole
	 * @return
	 */
	IPage<SysUserRoleVO> selectSysUserRolePage(IPage<SysUserRoleVO> page, SysUserRoleVO sysUserRole);

}
