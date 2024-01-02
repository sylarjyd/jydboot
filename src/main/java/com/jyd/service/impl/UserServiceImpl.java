package com.jyd.service.impl;

import com.jyd.entity.User;
import com.jyd.vo.UserVO;
import com.jyd.mapper.UserMapper;
import com.jyd.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 门户用户 服务实现类
 *
 * @author
 * @since 2023-12-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	@Override
	public IPage<UserVO> selectUserPage(IPage<UserVO> page, UserVO user) {
		return page.setRecords(baseMapper.selectUserPage(page, user));
	}

	@Override
	public Boolean register(User user) {
		boolean save = this.save(user);
		return save;
	}

	@Override
	public User login(User user) {
		return user;
	}

	@Override
	public Boolean reset(User user) {
		return null;
	}
}
