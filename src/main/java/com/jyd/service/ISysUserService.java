package com.jyd.service;

import com.jyd.entity.SysUser;
import com.jyd.vo.SysUserVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 系统用户 服务类
 *
 * @author 
 * @since 2023-12-01
 */
public interface ISysUserService extends IService<SysUser> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param sysUser
	 * @return
	 */
	IPage<SysUserVO> selectSysUserPage(IPage<SysUserVO> page, SysUserVO sysUser);

}
