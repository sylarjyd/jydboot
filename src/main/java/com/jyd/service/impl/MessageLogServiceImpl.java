package com.jyd.service.impl;

import com.jyd.entity.MessageLog;
import com.jyd.vo.MessageLogVO;
import com.jyd.mapper.MessageLogMapper;
import com.jyd.service.IMessageLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 消息日志 服务实现类
 *
 * @author 
 * @since 2023-12-01
 */
@Service
public class MessageLogServiceImpl extends ServiceImpl<MessageLogMapper, MessageLog> implements IMessageLogService {

	@Override
	public IPage<MessageLogVO> selectMessageLogPage(IPage<MessageLogVO> page, MessageLogVO messageLog) {
		return page.setRecords(baseMapper.selectMessageLogPage(page, messageLog));
	}

}
