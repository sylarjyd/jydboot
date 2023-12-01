package com.jyd.service.impl;

import com.jyd.entity.File;
import com.jyd.vo.FileVO;
import com.jyd.mapper.FileMapper;
import com.jyd.service.IFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 文件存储 服务实现类
 *
 * @author 
 * @since 2023-12-01
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

	@Override
	public IPage<FileVO> selectFilePage(IPage<FileVO> page, FileVO file) {
		return page.setRecords(baseMapper.selectFilePage(page, file));
	}

}
