package com.jyd.vo;

import com.jyd.entity.OssFile;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文件存储视图实体类
 *
 * @author
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "FileVO对象", description = "文件存储")
public class FileVO extends OssFile {
	private static final long serialVersionUID = 1L;

}
