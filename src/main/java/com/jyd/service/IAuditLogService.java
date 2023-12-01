package com.jyd.service;

import com.jyd.entity.AuditLog;
import com.jyd.vo.AuditLogVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 审核日志 服务类
 *
 * @author 
 * @since 2023-12-01
 */
public interface IAuditLogService extends IService<AuditLog> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param auditLog
	 * @return
	 */
	IPage<AuditLogVO> selectAuditLogPage(IPage<AuditLogVO> page, AuditLogVO auditLog);

}
