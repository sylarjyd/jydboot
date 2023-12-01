package com.jyd.mapper;

import com.jyd.entity.MessageLog;
import com.jyd.vo.MessageLogVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 消息日志 Mapper 接口
 *
 * @author 
 * @since 2023-12-01
 */
@Mapper
public interface MessageLogMapper extends BaseMapper<MessageLog> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param messageLog
	 * @return
	 */
	List<MessageLogVO> selectMessageLogPage(IPage page, MessageLogVO messageLog);

}
