package com.jyd.service;

import com.jyd.entity.File;
import com.jyd.vo.FileVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 文件存储 服务类
 *
 * @author 
 * @since 2023-12-01
 */
public interface IFileService extends IService<File> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param file
	 * @return
	 */
	IPage<FileVO> selectFilePage(IPage<FileVO> page, FileVO file);

}
