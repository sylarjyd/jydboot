package com.jyd.mapper;

import com.jyd.entity.SysUserRole;
import com.jyd.vo.SysUserRoleVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 用户-角色 Mapper 接口
 *
 * @author 
 * @since 2023-12-01
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param sysUserRole
	 * @return
	 */
	List<SysUserRoleVO> selectSysUserRolePage(IPage page, SysUserRoleVO sysUserRole);

}
