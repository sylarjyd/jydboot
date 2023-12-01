package com.jyd.dto;

import com.jyd.entity.File;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文件存储数据传输对象实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FileDTO extends File {
	private static final long serialVersionUID = 1L;

}
