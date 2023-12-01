package com.jyd.service.impl;

import com.jyd.entity.SysMenu;
import com.jyd.vo.SysMenuVO;
import com.jyd.mapper.SysMenuMapper;
import com.jyd.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 权限 服务实现类
 *
 * @author 
 * @since 2023-12-01
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

	@Override
	public IPage<SysMenuVO> selectSysMenuPage(IPage<SysMenuVO> page, SysMenuVO sysMenu) {
		return page.setRecords(baseMapper.selectSysMenuPage(page, sysMenu));
	}

}
