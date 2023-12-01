package com.jyd.dto;

import com.jyd.entity.MessageLog;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 消息日志数据传输对象实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MessageLogDTO extends MessageLog {
	private static final long serialVersionUID = 1L;

}
