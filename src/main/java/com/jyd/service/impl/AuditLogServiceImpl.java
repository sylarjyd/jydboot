package com.jyd.service.impl;

import com.jyd.entity.AuditLog;
import com.jyd.vo.AuditLogVO;
import com.jyd.mapper.AuditLogMapper;
import com.jyd.service.IAuditLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 审核日志 服务实现类
 *
 * @author 
 * @since 2023-12-01
 */
@Service
public class AuditLogServiceImpl extends ServiceImpl<AuditLogMapper, AuditLog> implements IAuditLogService {

	@Override
	public IPage<AuditLogVO> selectAuditLogPage(IPage<AuditLogVO> page, AuditLogVO auditLog) {
		return page.setRecords(baseMapper.selectAuditLogPage(page, auditLog));
	}

}
