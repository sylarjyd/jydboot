package com.jyd.dto;

import com.jyd.entity.SysUserRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户-角色数据传输对象实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserRoleDTO extends SysUserRole {
	private static final long serialVersionUID = 1L;

}
