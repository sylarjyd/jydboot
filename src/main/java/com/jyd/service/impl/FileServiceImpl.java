package com.jyd.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jyd.entity.OssFile;
import com.jyd.mapper.FileMapper;
import com.jyd.service.IFileService;
import com.jyd.vo.FileVO;
import org.springframework.stereotype.Service;

/**
 * 文件存储 服务实现类
 *
 * @author
 * @since 2023-12-01
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, OssFile> implements IFileService {

	@Override
	public IPage<FileVO> selectFilePage(IPage<FileVO> page, FileVO file) {
		return page.setRecords(baseMapper.selectFilePage(page, file));
	}

}
