package com.jyd.dto;

import com.jyd.entity.AuditLog;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 审核日志数据传输对象实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AuditLogDTO extends AuditLog {
	private static final long serialVersionUID = 1L;

}
