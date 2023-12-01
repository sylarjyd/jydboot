package com.jyd.mapper;

import com.jyd.entity.SysPost;
import com.jyd.vo.SysPostVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 岗位 Mapper 接口
 *
 * @author 
 * @since 2023-12-01
 */
@Mapper
public interface SysPostMapper extends BaseMapper<SysPost> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param sysPost
	 * @return
	 */
	List<SysPostVO> selectSysPostPage(IPage page, SysPostVO sysPost);

}
