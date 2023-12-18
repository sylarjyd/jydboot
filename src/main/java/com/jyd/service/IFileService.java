package com.jyd.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jyd.entity.OssFile;
import com.jyd.vo.FileVO;

/**
 * 文件存储 服务类
 *
 * @author
 * @since 2023-12-01
 */
public interface IFileService extends IService<OssFile> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param file
	 * @return
	 */
	IPage<FileVO> selectFilePage(IPage<FileVO> page, FileVO file);

}
