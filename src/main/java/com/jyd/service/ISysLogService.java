package com.jyd.service;

import com.jyd.entity.SysLog;
import com.jyd.vo.SysLogVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 系统日志 服务类
 *
 * @author 
 * @since 2023-12-01
 */
public interface ISysLogService extends IService<SysLog> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param sysLog
	 * @return
	 */
	IPage<SysLogVO> selectSysLogPage(IPage<SysLogVO> page, SysLogVO sysLog);

}
