package com.jyd.mapper;

import com.jyd.entity.PortalUser;
import com.jyd.vo.PortalUserVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 门户用户 Mapper 接口
 *
 * @author
 * @since 2023-07-19
 */
@Mapper
public interface PortalUserMapper extends BaseMapper<PortalUser> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param portalUser
	 * @return
	 */
	List<PortalUserVO> selectPortalUserPage(IPage page, PortalUserVO portalUser);

}
