package com.jyd.mapper;

import com.jyd.entity.User;
import com.jyd.vo.UserVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 门户用户 Mapper 接口
 *
 * @author 
 * @since 2023-12-01
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param user
	 * @return
	 */
	List<UserVO> selectUserPage(IPage page, UserVO user);

}
