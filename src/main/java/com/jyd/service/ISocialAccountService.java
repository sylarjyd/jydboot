package com.jyd.service;

import com.jyd.entity.SocialAccount;
import com.jyd.vo.SocialAccountVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 社交账号表 服务类
 *
 * @author 
 * @since 2023-12-01
 */
public interface ISocialAccountService extends IService<SocialAccount> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param socialAccount
	 * @return
	 */
	IPage<SocialAccountVO> selectSocialAccountPage(IPage<SocialAccountVO> page, SocialAccountVO socialAccount);

}
