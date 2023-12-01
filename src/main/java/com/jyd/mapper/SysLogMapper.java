package com.jyd.mapper;

import com.jyd.entity.SysLog;
import com.jyd.vo.SysLogVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 系统日志 Mapper 接口
 *
 * @author 
 * @since 2023-12-01
 */
@Mapper
public interface SysLogMapper extends BaseMapper<SysLog> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param sysLog
	 * @return
	 */
	List<SysLogVO> selectSysLogPage(IPage page, SysLogVO sysLog);

}
