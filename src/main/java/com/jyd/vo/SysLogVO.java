package com.jyd.vo;

import com.jyd.entity.SysLog;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 系统日志视图实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysLogVO对象", description = "系统日志")
public class SysLogVO extends SysLog {
	private static final long serialVersionUID = 1L;

}
