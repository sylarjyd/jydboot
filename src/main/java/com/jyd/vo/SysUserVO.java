package com.jyd.vo;

import com.jyd.entity.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 系统用户视图实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysUserVO对象", description = "系统用户")
public class SysUserVO extends SysUser {
	private static final long serialVersionUID = 1L;

}
