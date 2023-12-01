package com.jyd.mapper;

import com.jyd.entity.SocialAccount;
import com.jyd.vo.SocialAccountVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 社交账号表 Mapper 接口
 *
 * @author 
 * @since 2023-12-01
 */
@Mapper
public interface SocialAccountMapper extends BaseMapper<SocialAccount> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param socialAccount
	 * @return
	 */
	List<SocialAccountVO> selectSocialAccountPage(IPage page, SocialAccountVO socialAccount);

}
