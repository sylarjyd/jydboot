package com.jyd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 社交账号表实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@TableName("t_social_account")
@ApiModel(value = "SocialAccount对象", description = "社交账号表")
public class SocialAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* 主键
	*/
		@ApiModelProperty(value = "主键")
		private String id;
	/**
	* 用户ID
	*/
		@ApiModelProperty(value = "用户ID")
		private String userId;
	/**
	* 用户类型，1系统用户，2客户端用户
	*/
		@ApiModelProperty(value = "用户类型，1系统用户，2客户端用户")
		private Integer userType;
	/**
	* 社交应用类型，例如qq，weixin
	*/
		@ApiModelProperty(value = "社交应用类型，例如qq，weixin")
		private String socialCode;
	/**
	* 社交账号信息
	*/
		@ApiModelProperty(value = "社交账号信息")
		private String socialAccount;


}
