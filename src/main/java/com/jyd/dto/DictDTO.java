package com.jyd.dto;

import com.jyd.entity.Dict;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典数据传输对象实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DictDTO extends Dict {
	private static final long serialVersionUID = 1L;

}
