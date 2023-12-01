package com.jyd.service;

import com.jyd.entity.MessageLog;
import com.jyd.vo.MessageLogVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 消息日志 服务类
 *
 * @author 
 * @since 2023-12-01
 */
public interface IMessageLogService extends IService<MessageLog> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param messageLog
	 * @return
	 */
	IPage<MessageLogVO> selectMessageLogPage(IPage<MessageLogVO> page, MessageLogVO messageLog);

}
