package com.jyd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 角色-权限实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@TableName("t_sys_role_menu")
@ApiModel(value = "SysRoleMenu对象", description = "角色-权限")
public class SysRoleMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* ID
	*/
		@ApiModelProperty(value = "ID")
		private String id;
	/**
	* 角色ID
	*/
		@ApiModelProperty(value = "角色ID")
		private String roleId;
	/**
	* 权限ID
	*/
		@ApiModelProperty(value = "权限ID")
		private String menuId;


}
