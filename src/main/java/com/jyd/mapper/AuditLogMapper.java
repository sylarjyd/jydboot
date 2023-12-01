package com.jyd.mapper;

import com.jyd.entity.AuditLog;
import com.jyd.vo.AuditLogVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 审核日志 Mapper 接口
 *
 * @author 
 * @since 2023-12-01
 */
@Mapper
public interface AuditLogMapper extends BaseMapper<AuditLog> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param auditLog
	 * @return
	 */
	List<AuditLogVO> selectAuditLogPage(IPage page, AuditLogVO auditLog);

}
