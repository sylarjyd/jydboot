package com.jyd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 门户用户实体类
 *
 * @author 
 * @since 2023-07-19
 */
@Data
@TableName("t_portal_user")
@ApiModel(value = "PortalUser对象", description = "门户用户")
public class PortalUser implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* ID
	*/
		@ApiModelProperty(value = "ID")
		private String id;
	/**
	* 创建时间
	*/
		@ApiModelProperty(value = "创建时间")
		private Date createTime;
	/**
	* 更新时间
	*/
		@ApiModelProperty(value = "更新时间")
		private Date updateTime;
	/**
	* 创建人
	*/
		@ApiModelProperty(value = "创建人")
		private String createUser;
	/**
	* 更新人
	*/
		@ApiModelProperty(value = "更新人")
		private String updateUser;
	/**
	* 状态 0正常 1锁定
	*/
		@ApiModelProperty(value = "状态 0正常 1锁定")
		private Integer status;
	/**
	* 删除标记 0正常 1删除
	*/
		@ApiModelProperty(value = "删除标记 0正常 1删除")
		private Integer deleted;
	/**
	* 账号
	*/
		@ApiModelProperty(value = "账号")
		private String account;
	/**
	* 密码
	*/
		@ApiModelProperty(value = "密码")
		private String password;
	/**
	* 手机号
	*/
		@ApiModelProperty(value = "手机号")
		private String telephone;
	/**
	* 备注
	*/
		@ApiModelProperty(value = "备注")
		private String mark;
	/**
	* 头像
	*/
		@ApiModelProperty(value = "头像")
		private String headerImage;


}
