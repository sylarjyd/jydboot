package com.jyd.service.impl;

import com.jyd.entity.SocialAccount;
import com.jyd.vo.SocialAccountVO;
import com.jyd.mapper.SocialAccountMapper;
import com.jyd.service.ISocialAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 社交账号表 服务实现类
 *
 * @author 
 * @since 2023-12-01
 */
@Service
public class SocialAccountServiceImpl extends ServiceImpl<SocialAccountMapper, SocialAccount> implements ISocialAccountService {

	@Override
	public IPage<SocialAccountVO> selectSocialAccountPage(IPage<SocialAccountVO> page, SocialAccountVO socialAccount) {
		return page.setRecords(baseMapper.selectSocialAccountPage(page, socialAccount));
	}

}
