package com.jyd.vo;

import com.jyd.entity.SysUserRole;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 用户-角色视图实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysUserRoleVO对象", description = "用户-角色")
public class SysUserRoleVO extends SysUserRole {
	private static final long serialVersionUID = 1L;

}
