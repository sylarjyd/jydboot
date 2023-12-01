package com.jyd.mapper;

import com.jyd.entity.SysNotice;
import com.jyd.vo.SysNoticeVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 新闻公告 Mapper 接口
 *
 * @author 
 * @since 2023-12-01
 */
@Mapper
public interface SysNoticeMapper extends BaseMapper<SysNotice> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param sysNotice
	 * @return
	 */
	List<SysNoticeVO> selectSysNoticePage(IPage page, SysNoticeVO sysNotice);

}
