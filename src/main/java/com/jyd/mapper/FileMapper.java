package com.jyd.mapper;

import com.jyd.entity.File;
import com.jyd.vo.FileVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 文件存储 Mapper 接口
 *
 * @author 
 * @since 2023-12-01
 */
@Mapper
public interface FileMapper extends BaseMapper<File> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param file
	 * @return
	 */
	List<FileVO> selectFilePage(IPage page, FileVO file);

}
