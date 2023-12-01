package com.jyd.service;

import com.jyd.entity.SysNotice;
import com.jyd.vo.SysNoticeVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 新闻公告 服务类
 *
 * @author 
 * @since 2023-12-01
 */
public interface ISysNoticeService extends IService<SysNotice> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param sysNotice
	 * @return
	 */
	IPage<SysNoticeVO> selectSysNoticePage(IPage<SysNoticeVO> page, SysNoticeVO sysNotice);

}
