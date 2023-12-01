package com.jyd.service;

import com.jyd.entity.User;
import com.jyd.vo.UserVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 门户用户 服务类
 *
 * @author 
 * @since 2023-12-01
 */
public interface IUserService extends IService<User> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param user
	 * @return
	 */
	IPage<UserVO> selectUserPage(IPage<UserVO> page, UserVO user);

}
