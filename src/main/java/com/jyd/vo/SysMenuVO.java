package com.jyd.vo;

import com.jyd.entity.SysMenu;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 权限视图实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysMenuVO对象", description = "权限")
public class SysMenuVO extends SysMenu {
	private static final long serialVersionUID = 1L;

}
