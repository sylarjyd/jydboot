package com.jyd.mapper;

import com.jyd.entity.SysRoleMenu;
import com.jyd.vo.SysRoleMenuVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 角色-权限 Mapper 接口
 *
 * @author 
 * @since 2023-12-01
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param sysRoleMenu
	 * @return
	 */
	List<SysRoleMenuVO> selectSysRoleMenuPage(IPage page, SysRoleMenuVO sysRoleMenu);

}
