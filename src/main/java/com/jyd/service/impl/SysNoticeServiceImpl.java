package com.jyd.service.impl;

import com.jyd.entity.SysNotice;
import com.jyd.vo.SysNoticeVO;
import com.jyd.mapper.SysNoticeMapper;
import com.jyd.service.ISysNoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 新闻公告 服务实现类
 *
 * @author 
 * @since 2023-12-01
 */
@Service
public class SysNoticeServiceImpl extends ServiceImpl<SysNoticeMapper, SysNotice> implements ISysNoticeService {

	@Override
	public IPage<SysNoticeVO> selectSysNoticePage(IPage<SysNoticeVO> page, SysNoticeVO sysNotice) {
		return page.setRecords(baseMapper.selectSysNoticePage(page, sysNotice));
	}

}
