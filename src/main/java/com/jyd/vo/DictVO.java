package com.jyd.vo;

import com.jyd.entity.Dict;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 字典视图实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "DictVO对象", description = "字典")
public class DictVO extends Dict {
	private static final long serialVersionUID = 1L;

}
