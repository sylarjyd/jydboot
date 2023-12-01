package com.jyd.vo;

import com.jyd.entity.SysPost;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 岗位视图实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysPostVO对象", description = "岗位")
public class SysPostVO extends SysPost {
	private static final long serialVersionUID = 1L;

}
