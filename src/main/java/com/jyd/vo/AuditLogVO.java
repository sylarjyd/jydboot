package com.jyd.vo;

import com.jyd.entity.AuditLog;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 审核日志视图实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "AuditLogVO对象", description = "审核日志")
public class AuditLogVO extends AuditLog {
	private static final long serialVersionUID = 1L;

}
