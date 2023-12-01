package com.jyd.vo;

import com.jyd.entity.MessageLog;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 消息日志视图实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "MessageLogVO对象", description = "消息日志")
public class MessageLogVO extends MessageLog {
	private static final long serialVersionUID = 1L;

}
