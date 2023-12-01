package com.jyd.mapper;

import com.jyd.entity.SysMenu;
import com.jyd.vo.SysMenuVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 权限 Mapper 接口
 *
 * @author 
 * @since 2023-12-01
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param sysMenu
	 * @return
	 */
	List<SysMenuVO> selectSysMenuPage(IPage page, SysMenuVO sysMenu);

}
