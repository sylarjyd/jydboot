package com.jyd.dto;

import com.jyd.entity.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统用户数据传输对象实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserDTO extends SysUser {
	private static final long serialVersionUID = 1L;

}
