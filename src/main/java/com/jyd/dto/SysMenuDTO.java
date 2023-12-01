package com.jyd.dto;

import com.jyd.entity.SysMenu;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 权限数据传输对象实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysMenuDTO extends SysMenu {
	private static final long serialVersionUID = 1L;

}
