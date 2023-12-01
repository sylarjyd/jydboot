package com.jyd.vo;

import com.jyd.entity.SysRoleMenu;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 角色-权限视图实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysRoleMenuVO对象", description = "角色-权限")
public class SysRoleMenuVO extends SysRoleMenu {
	private static final long serialVersionUID = 1L;

}
