package com.jyd.dto;

import com.jyd.entity.SysLog;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统日志数据传输对象实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysLogDTO extends SysLog {
	private static final long serialVersionUID = 1L;

}
