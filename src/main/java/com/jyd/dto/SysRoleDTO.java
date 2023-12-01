package com.jyd.dto;

import com.jyd.entity.SysRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色数据传输对象实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleDTO extends SysRole {
	private static final long serialVersionUID = 1L;

}
