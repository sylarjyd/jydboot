package com.jyd.vo;

import com.jyd.entity.File;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 文件存储视图实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "FileVO对象", description = "文件存储")
public class FileVO extends File {
	private static final long serialVersionUID = 1L;

}
