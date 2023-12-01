package com.jyd.mapper;

import com.jyd.entity.SysUser;
import com.jyd.vo.SysUserVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 系统用户 Mapper 接口
 *
 * @author 
 * @since 2023-12-01
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param sysUser
	 * @return
	 */
	List<SysUserVO> selectSysUserPage(IPage page, SysUserVO sysUser);

}
