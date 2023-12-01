package com.jyd.service;

import com.jyd.entity.SysMenu;
import com.jyd.vo.SysMenuVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 权限 服务类
 *
 * @author 
 * @since 2023-12-01
 */
public interface ISysMenuService extends IService<SysMenu> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param sysMenu
	 * @return
	 */
	IPage<SysMenuVO> selectSysMenuPage(IPage<SysMenuVO> page, SysMenuVO sysMenu);

}
