package com.jyd.dto;

import com.jyd.entity.SysRoleMenu;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色-权限数据传输对象实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleMenuDTO extends SysRoleMenu {
	private static final long serialVersionUID = 1L;

}
