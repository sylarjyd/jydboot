package com.jyd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户-角色实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@TableName("t_sys_user_role")
@ApiModel(value = "SysUserRole对象", description = "用户-角色")
public class SysUserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* ID
	*/
		@ApiModelProperty(value = "ID")
		private String id;
	/**
	* 用户ID
	*/
		@ApiModelProperty(value = "用户ID")
		private String userId;
	/**
	* 角色ID
	*/
		@ApiModelProperty(value = "角色ID")
		private String roleId;


}
