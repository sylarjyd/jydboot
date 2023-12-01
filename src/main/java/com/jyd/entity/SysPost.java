package com.jyd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 岗位实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@TableName("t_sys_post")
@ApiModel(value = "SysPost对象", description = "岗位")
public class SysPost implements Serializable {

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
	* 岗位编码
	*/
		@ApiModelProperty(value = "岗位编码")
		private String postCode;
	/**
	* 岗位名称
	*/
		@ApiModelProperty(value = "岗位名称")
		private String postName;
	/**
	* 备注
	*/
		@ApiModelProperty(value = "备注")
		private String mark;
	/**
	* 部门ID
	*/
		@ApiModelProperty(value = "部门ID")
		private String deptId;


}
