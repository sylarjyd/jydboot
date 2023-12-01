package com.jyd.mapper;

import com.jyd.entity.SysDept;
import com.jyd.vo.SysDeptVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 部门 Mapper 接口
 *
 * @author 
 * @since 2023-12-01
 */
@Mapper
public interface SysDeptMapper extends BaseMapper<SysDept> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param sysDept
	 * @return
	 */
	List<SysDeptVO> selectSysDeptPage(IPage page, SysDeptVO sysDept);

}
