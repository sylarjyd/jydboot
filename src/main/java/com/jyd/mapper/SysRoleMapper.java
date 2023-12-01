package com.jyd.mapper;

import com.jyd.entity.SysRole;
import com.jyd.vo.SysRoleVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 角色 Mapper 接口
 *
 * @author 
 * @since 2023-12-01
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param sysRole
	 * @return
	 */
	List<SysRoleVO> selectSysRolePage(IPage page, SysRoleVO sysRole);

}
