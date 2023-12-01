package com.jyd.mapper;

import com.jyd.entity.District;
import com.jyd.vo.DistrictVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 区划 Mapper 接口
 *
 * @author 
 * @since 2023-12-01
 */
@Mapper
public interface DistrictMapper extends BaseMapper<District> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param district
	 * @return
	 */
	List<DistrictVO> selectDistrictPage(IPage page, DistrictVO district);

}
