package com.jyd.vo;

import com.jyd.entity.SysRole;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 角色视图实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysRoleVO对象", description = "角色")
public class SysRoleVO extends SysRole {
	private static final long serialVersionUID = 1L;

}
