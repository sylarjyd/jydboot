package com.jyd.service.impl;

import com.jyd.entity.SysLog;
import com.jyd.vo.SysLogVO;
import com.jyd.mapper.SysLogMapper;
import com.jyd.service.ISysLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 系统日志 服务实现类
 *
 * @author 
 * @since 2023-12-01
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

	@Override
	public IPage<SysLogVO> selectSysLogPage(IPage<SysLogVO> page, SysLogVO sysLog) {
		return page.setRecords(baseMapper.selectSysLogPage(page, sysLog));
	}

}
